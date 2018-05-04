package com.hunsy.pointshop.api.vo;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 普通的用户事件，非连续的。
 */
public class UserEventInVo implements Serializable {

    @NotNull
    private Long appId;
    @NotNull
    private Long serialId;
    @NotNull
    private String userAccount;

    private Integer times = 1;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
