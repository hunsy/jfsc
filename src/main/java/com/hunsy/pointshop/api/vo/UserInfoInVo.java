package com.hunsy.pointshop.api.vo;


import javax.validation.constraints.NotNull;

public class UserInfoInVo {

    @NotNull
    private Long appId;
    @NotNull
    private String userAccount;
    private String nickName;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
