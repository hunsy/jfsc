package com.hunsy.pointshop.api.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 应用开发者关联列表显示Vo
 */
public class DeveloperUpdateInVo implements Serializable {

    @NotNull
    private String nickName;
    private String avatar;
    private String email;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
