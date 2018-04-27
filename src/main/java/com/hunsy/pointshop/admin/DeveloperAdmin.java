package com.hunsy.pointshop.admin;

import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.service.DeveloperService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 开发者后台管理接口
 * DeveloperAdmin
 */
@RestController
@RequestMapping(value = "admin/developer")
public class DeveloperAdmin {

    @Autowired
    private DeveloperService developerService;

    /**
     * 后台新增开发者
     *
     * @param developer 开发者
     */
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody AppDeveloper developer) throws BizException {
        developer.setNickName(RandomStringUtils.randomAlphanumeric(6));
        boolean flag = developerService.saveDev(developer);
        return ResponseEntity.ok("1");
    }

    /**
     * 更新开发者
     *
     * @param developer 开发者
     */
    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody AppDeveloper developer) {

        boolean flag = developerService.updatedSelective(developer) == 1;
        return ResponseEntity.ok("1");
    }

}