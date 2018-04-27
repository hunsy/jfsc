package com.hunsy.pointshop.api.vo;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AppDevInVo implements Serializable {

    @NotNull
    private String mobile;
    @NotNull
    private Long appId;
    @NotNull
    private String role;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
