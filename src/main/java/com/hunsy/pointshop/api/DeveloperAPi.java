package com.hunsy.pointshop.api;

import com.hunsy.pointshop.api.vo.AppDevItemvo;
import com.hunsy.pointshop.api.vo.ProfileOutVo;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.dto.AppDevDto;
import com.hunsy.pointshop.service.AppDevService;
import com.hunsy.pointshop.service.AppService;
import com.hunsy.pointshop.service.DeveloperService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class DeveloperAPi {

    @Autowired
    private DeveloperService developerService;
    @Autowired
    private AppService appService;
    @Autowired
    private AppDevService appDevService;


    @PostMapping(value = "register")
    public ResponseEntity<Object> register(@Valid @RequestBody AppDeveloper developer) throws BizException {

        developer.setNickName(RandomStringUtils.randomAlphanumeric(6));
        boolean flag = developerService.saveDev(developer);
        return ResponseEntity.ok(DataRet.success());
    }

    /**
     * 获取用户详情
     *
     * @return
     */
    @GetMapping(value = "profile")
    public ResponseEntity<Object> profile() {

        AppDeveloper developer = (AppDeveloper) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ProfileOutVo vo = new ProfileOutVo();
        BeanUtils.copyProperties(developer, vo);
        return ResponseEntity.ok(DataRet.success(vo));
    }


    /**
     * 当前开发者用于的应用。
     *
     * @return ResponseEntity
     */
    @GetMapping(value = "apps")
    public ResponseEntity<Object> apps() {

        AppDeveloper developer = MySecurityContextUtil.getDev();
        List<AppDevDto> appDevs = appDevService.findByDeveloper(developer.getId());
        List<AppDevItemvo> vos = new ArrayList<>();
        if (appDevs != null && !appDevs.isEmpty()) {
            appDevs.forEach(dev -> {
                AppDevItemvo vo = new AppDevItemvo();
                BeanUtils.copyProperties(dev, vo);
                vos.add(vo);
            });
        }
        return ResponseEntity.ok(DataRet.success(vos));
    }

    @PutMapping("setDef/{appDevId}")
    public ResponseEntity<Object> setDef(@PathVariable("appDevId") Long appDevId) {

        appDevService.setDef(appDevId);

        return ResponseEntity.ok(DataRet.success());
    }

}
