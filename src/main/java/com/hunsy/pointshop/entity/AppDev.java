package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class AppDev extends BaseEntity {


    /**
     * 开发者id
     */
    @NotEmpty
    private Long devId;

    /**
     * 应用id
     */
    @NotEmpty
    private Long appId;

    /**
     * 角色 owner 拥有者  master 管理员  developer 开发者
     */
    private String role;

    private Date createdAt;

    private Date updatedAt;

    private Integer valid;

    private Integer isDefault;


    /**
     * 获取开发者id
     *
     * @return dev_id - 开发者id
     */
    public Long getDevId() {
        return devId;
    }

    /**
     * 设置开发者id
     *
     * @param devId 开发者id
     */
    public void setDevId(Long devId) {
        this.devId = devId;
    }

    /**
     * 获取应用id
     *
     * @return app_id - 应用id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置应用id
     *
     * @param appId 应用id
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取角色 owner 拥有者  master 管理员  developer 开发者
     *
     * @return role - 角色 owner 拥有者  master 管理员  developer 开发者
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置角色 owner 拥有者  master 管理员  developer 开发者
     *
     * @param role 角色 owner 拥有者  master 管理员  developer 开发者
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

}