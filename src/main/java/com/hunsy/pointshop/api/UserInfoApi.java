package com.hunsy.pointshop.api;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.UserInfoInVo;
import com.hunsy.pointshop.api.vo.UserInfoOutVo;
import com.hunsy.pointshop.api.vo.UserInfoPageItemOutVo;
import com.hunsy.pointshop.api.vo.UserInfoUpdateInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.response.PageRetVo;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.UserInfo;
import com.hunsy.pointshop.service.UserInfoService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserInfoApi {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody UserInfoInVo vo) throws BizException {
        AppDeveloper operate = MySecurityContextUtil.getDev();

        UserInfo dbUser = userInfoService.findByAccount(vo.getAppId(), vo.getUserAccount());
        if (dbUser != null) {
            throw new BizException(RetCode.USER_EXIST);
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(vo, userInfo);
        if (StringUtils.isEmpty(userInfo.getNickName())) {
            userInfo.setNickName(RandomStringUtils.randomAlphanumeric(6));
        }
        userInfo.setCreatedBy(operate.getId());
        boolean flag = userInfoService.saveInfo(userInfo);
        return ResponseEntity.ok(DataRet.success());
    }


    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody UserInfoUpdateInVo vo) {


        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(vo, userInfo);
        boolean flag = userInfoService.updateInfo(userInfo);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping("{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) throws BizException {
        UserInfo userInfo = userInfoService.findById(id);
        if (userInfo == null) {
            throw new BizException(RetCode.USER_NOT_EXIST);
        }

        UserInfoOutVo vo = new UserInfoOutVo();
        BeanUtils.copyProperties(userInfo, vo);
        return ResponseEntity.ok(DataRet.success(vo));
    }

    @GetMapping("page")
    public ResponseEntity<Object> page(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            UserInfo params
    ) {

        PageInfo<UserInfo> pageInfo = userInfoService.findPage(pageNo, pageSize, params);
        List<UserInfoPageItemOutVo> vos = new ArrayList<>();
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
            pageInfo.getList().forEach(userInfo -> {
                UserInfoPageItemOutVo vo = new UserInfoPageItemOutVo();
                BeanUtils.copyProperties(userInfo, vo);
                vos.add(vo);
            });
        }

        PageInfo<UserInfoPageItemOutVo> pg = new PageInfo<>(vos);
        return ResponseEntity.ok(DataRet.success(new PageRetVo<>(pg)));
    }


}
