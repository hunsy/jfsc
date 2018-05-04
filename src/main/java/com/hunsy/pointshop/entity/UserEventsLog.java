package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_events_log")
public class UserEventsLog extends BaseEntity {


    @Column(name = "app_id")
    private Long appId;

    /**
     * 勋章系列id
     */
    @Column(name = "serial_id")
    private Long serialId;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 次数
     */
    private Integer times;

    @Column(name = "created_at")
    private Date createdAt;


    /**
     * @return app_id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取勋章系列id
     *
     * @return serial_id - 勋章系列id
     */
    public Long getSerialId() {
        return serialId;
    }

    /**
     * 设置勋章系列id
     *
     * @param serialId 勋章系列id
     */
    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    /**
     * 获取用户账号
     *
     * @return user_account - 用户账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置用户账号
     *
     * @param userAccount 用户账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取次数
     *
     * @return times - 次数
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 设置次数
     *
     * @param times 次数
     */
    public void setTimes(Integer times) {
        this.times = times;
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
}