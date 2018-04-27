package com.hunsy.pointshop.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hunsy.pointshop.entity.AppDev;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用与开发者关系扩展
 */
public class AppDevDto extends AppDev implements Serializable {

    //应用名
    private String name;
    //开发者昵称
    private String nickName;
    //开发者邮箱
    private String email;

    private String countryCode;
    //开发者手机号码
    private String mobile;

    private String avatar;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
