package com.hunsy.pointshop.api.vo;


import javax.validation.constraints.NotNull;

public class UserInfoUpdateInVo {
    @NotNull
    private Long id;
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
