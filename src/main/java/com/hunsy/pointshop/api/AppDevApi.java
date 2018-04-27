package com.hunsy.pointshop.api;

import com.hunsy.pointshop.api.vo.AppDevInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDev;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.service.AppDevService;
import com.hunsy.pointshop.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/app/dev")
public class AppDevApi {

    @Autowired
    private AppDevService appDevService;
    @Autowired
    private DeveloperService developerService;


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody AppDevInVo vo) throws BizException {

        AppDeveloper developer = developerService.findByMobile(vo.getMobile());
        if (developer == null) {
            throw new BizException(RetCode.DEVELOPER_NOT_EXIST);
        }
        //简单是否可以操作
        AppDeveloper operator = MySecurityContextUtil.getDev();
        AppDev myAppDev = appDevService.findByAppAndDev(vo.getAppId(), operator.getId());
        if ("developer".equals(myAppDev.getRole())) {
            throw new BizException(RetCode.APP_DEV_NOT_PERMISSION);
        }

        AppDev dbAppDev = appDevService.findByAppAndDev(vo.getAppId(), developer.getId());
        if (dbAppDev != null) {
            throw new BizException(RetCode.APP_DEV_HAVE_EXIST);
        }
        AppDev appDev = new AppDev();
        appDev.setAppId(vo.getAppId());
        appDev.setDevId(developer.getId());
        appDev.setRole(vo.getRole());
        boolean flag = appDevService.saveAppDev(appDev);
        return ResponseEntity.ok(DataRet.success());
    }
}
