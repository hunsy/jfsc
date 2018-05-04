package com.hunsy.pointshop.api;


import com.hunsy.pointshop.api.vo.UserEventInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.entity.MedalSerial;
import com.hunsy.pointshop.entity.UserEvents;
import com.hunsy.pointshop.entity.UserInfo;
import com.hunsy.pointshop.service.MedalSerialService;
import com.hunsy.pointshop.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/userEvent")
public class UserEventApi {


    @Autowired
    private MedalSerialService medalSerialService;
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 新增用户获取勋章的记录
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> event(@Valid @RequestBody UserEventInVo vo) throws BizException {

        UserEvents events = new UserEvents();
        BeanUtils.copyProperties(vo, events);

        UserInfo ui = userInfoService.findByAccount(vo.getAppId(), vo.getUserAccount());
        if (ui == null) {
            throw new BizException(RetCode.USER_NOT_EXIST);
        }

        MedalSerial medalSerial = medalSerialService.findById(vo.getSerialId());
        if (medalSerial == null) {
            throw new BizException(RetCode.MEDAL_SERIAL_NOT_EXIST);
        }




    }


}
