package com.hunsy.pointshop.service;

import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.AppDeveloper;

import com.hunsy.pointshop.entity.dto.AppDevDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 开发者业务处理类
 * DeveloperService
 */
@Service
public class DeveloperService extends BaseService<AppDeveloper> {


    /**
     * 新增开发者
     *
     * @param developer
     */
    public boolean saveDev(AppDeveloper developer) throws BizException {
        if (StringUtils.isNotEmpty(developer.getMobile())) {
            if (checkMobileExist(developer.getCountryCode(), developer.getMobile())) {
                throw new BizException(RetCode.DEVELOPER_EXIST);
            }
        }
//        String salt = RandomStringUtils.randomAlphanumeric(16);
        String tmp = new BCryptPasswordEncoder().encode(developer.getPassword());
//        developer.setSalt(salt);
        developer.setPassword(tmp);
        return super.insertSelective(developer) == 1;
    }

    /**
     * 检查手机号码是否存在
     *
     * @param mobile 手机号码
     */
    public boolean checkMobileExist(String countryCode, String mobile) {
        //TO-DO 使用redis的列表检查
        AppDeveloper developer = new AppDeveloper();
        developer.setCountryCode(countryCode);
        developer.setMobile(mobile);

        return super.selectOne(developer) != null ? true : false;
    }


    /**
     * @param mobile
     * @return
     */
    public AppDeveloper findByMobile(String mobile) {

        AppDeveloper developer = new AppDeveloper();
        developer.setMobile(mobile);
        developer.setValid(1);
        return super.selectOne(developer);
    }

}