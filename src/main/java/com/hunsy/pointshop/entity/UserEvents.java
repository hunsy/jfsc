package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_events")
public class UserEvents extends BaseEntity {


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

    /**
     * 是否要求连续
     */
    @Column(name = "is_continuous")
    private Byte isContinuous;

    /**
     * 连续次数，主要用于周签，月签
     */
    @Column(name = "continuous_times")
    private Integer continuousTimes;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 1 有效 0 无效
     */
    private Byte valid;


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
     * 获取是否要求连续
     *
     * @return is_continuous - 是否要求连续
     */
    public Byte getIsContinuous() {
        return isContinuous;
    }

    /**
     * 设置是否要求连续
     *
     * @param isContinuous 是否要求连续
     */
    public void setIsContinuous(Byte isContinuous) {
        this.isContinuous = isContinuous;
    }

    /**
     * 获取连续次数，主要用于周签，月签
     *
     * @return continuous_times - 连续次数，主要用于周签，月签
     */
    public Integer getContinuousTimes() {
        return continuousTimes;
    }

    /**
     * 设置连续次数，主要用于周签，月签
     *
     * @param continuousTimes 连续次数，主要用于周签，月签
     */
    public void setContinuousTimes(Integer continuousTimes) {
        this.continuousTimes = continuousTimes;
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
     * 获取1 有效 0 无效
     *
     * @return valid - 1 有效 0 无效
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * 设置1 有效 0 无效
     *
     * @param valid 1 有效 0 无效
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}