package com.hunsy.pointshop.api;

import com.hunsy.pointshop.api.vo.AppInVo;
import com.hunsy.pointshop.api.vo.AppOutVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.App;
import com.hunsy.pointshop.entity.AppDev;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.dto.AppDevDto;
import com.hunsy.pointshop.service.AppDevService;
import com.hunsy.pointshop.service.AppService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/app")
public class AppApi {

    @Autowired
    private AppService appService;
    @Autowired
    private AppDevService appDevService;

    /**
     * 新增应用
     *
     * @param appInVo
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody AppInVo appInVo) {
        App app = new App();
        BeanUtils.copyProperties(appInVo, app);
        AppDeveloper developer = MySecurityContextUtil.getDev();
        app.setDevId(developer.getId());
        appService.saveApp(app);
        Map<String, String> map = new HashMap<>();
        map.put("appId", app.getId() + "");
        return ResponseEntity.ok(DataRet.success(map));
    }


    /**
     * 更新应用
     *
     * @return
     */
    @PutMapping
    public ResponseEntity<DataRet> update(@Valid @RequestBody AppInVo appInVo) throws BizException {

        App app = new App();
        BeanUtils.copyProperties(appInVo, app);
        AppDeveloper developer = MySecurityContextUtil.getDev();
        AppDev dev = appDevService.findByAppAndDev(app.getId(), developer.getId());
        if (dev == null) {
            throw new BizException(RetCode.APP_DEV_NOT_EXIST);
        }
        //开发权限不可以修改应用。
        if ("developer".equals(dev.getRole())) {
            throw new BizException(RetCode.APP_DEV_NOT_PERMISSION);
        }
        appService.updatedSelective(app);
        return ResponseEntity.ok(DataRet.success());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DataRet> get(@PathVariable("id") Long id) throws BizException {

        App app = appService.findById(id);
        if (app == null) {
            throw new BizException(RetCode.APP_NOT_EXIST);
        }
        AppOutVo vo = new AppOutVo();
        BeanUtils.copyProperties(app, vo);
        return ResponseEntity.ok(DataRet.success(vo));
    }

    /**
     * @return
     */
    @GetMapping(value = "developer/{appId}")
    public ResponseEntity<Object> developers(@PathVariable("appId") Long appId) {

        List<AppDevDto> appDevs = appDevService.findByApp(appId);
        return ResponseEntity.ok(DataRet.success(appDevs));
    }

}
