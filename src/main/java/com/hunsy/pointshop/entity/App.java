package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import java.util.Date;

public class App extends BaseEntity {

    /**
     * key
     */
    private String appKey;

    /**
     *
     */
    private String appSecret;

    private String name;

    /**
     *
     */
    private Long devId;

    /**
     *
     */
    private Byte status;

    /**
     *
     */
    private Date createdAt;

    /**
     *
     */
    private Date updatedAt;

    /**
     *
     */
    private Integer valid;


    /**
     *
     *
     * @return app_key
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     *
     *
     * @param appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     *
     * @return app_secret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     *
     * @param appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return dev_id -
     */
    public Long getDevId() {
        return devId;
    }

    /**
     *
     * @param devId
     */
    public void setDevId(Long devId) {
        this.devId = devId;
    }

    /**
     *
     * @return status -
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     *
     * @return created_at -
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return updated_at -
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return valid -
     */
    public Integer getValid() {
        return valid;
    }

    /**
     *
     * @param valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }
}