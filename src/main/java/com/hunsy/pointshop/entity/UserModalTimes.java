package com.hunsy.pointshop.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_modal_times")
public class UserModalTimes {
    @Id
    private Long id;

    /**
     * app_id
     */
    @Column(name = "app_id")
    private Long appId;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 事件码
     */
    @Column(name = "serial_id")
    private Long serialId;

    /**
     * 事件类型
     */
    @Column(name = "modal_type")
    private Integer modalType;

    /**
     * 事件触发次数
     */
    private Integer times;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 删除标识  1 正常 0 删除
     */
    private Byte valid;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取app_id
     *
     * @return app_id - app_id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置app_id
     *
     * @param appId app_id
     */
    public void setAppId(Long appId) {
        this.appId = appId;
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
     * 获取事件码
     *
     * @return serial_id - 事件码
     */
    public Long getSerialId() {
        return serialId;
    }

    /**
     * 设置事件码
     *
     * @param serialId 事件码
     */
    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    /**
     * 获取事件类型
     *
     * @return modal_type - 事件类型
     */
    public Integer getModalType() {
        return modalType;
    }

    /**
     * 设置事件类型
     *
     * @param modalType 事件类型
     */
    public void setModalType(Integer modalType) {
        this.modalType = modalType;
    }

    /**
     * 获取事件触发次数
     *
     * @return times - 事件触发次数
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 设置事件触发次数
     *
     * @param times 事件触发次数
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
     * 获取删除标识  1 正常 0 删除
     *
     * @return valid - 删除标识  1 正常 0 删除
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * 设置删除标识  1 正常 0 删除
     *
     * @param valid 删除标识  1 正常 0 删除
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}