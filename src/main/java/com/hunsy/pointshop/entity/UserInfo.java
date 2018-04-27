package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_info")
public class UserInfo extends BaseEntity {


    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "app_id")
    private Long appId;

    /**
     * 用户账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 获取的勋章数
     */
    @Column(name = "medal_num")
    private Integer medalNum;

    /**
     * 用户成长值
     */
    private Integer score;

    /**
     * 积分值
     */
    private Integer integral;

    /**
     * 当前等级
     */
    @Column(name = "current_level")
    private Long currentLevel;

    /**
     * 虚拟货币数
     */
    @Column(name = "virtual_icons")
    private Long virtualIcons;

    /**
     * 创建日期
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 更新日期
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 逻辑删除字段 1正常  0删除
     */
    private Byte valid;


    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

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
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取获取的勋章数
     *
     * @return medal_num - 获取的勋章数
     */
    public Integer getMedalNum() {
        return medalNum;
    }

    /**
     * 设置获取的勋章数
     *
     * @param medalNum 获取的勋章数
     */
    public void setMedalNum(Integer medalNum) {
        this.medalNum = medalNum;
    }

    /**
     * 获取用户成长值
     *
     * @return score - 用户成长值
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置用户成长值
     *
     * @param score 用户成长值
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取积分值
     *
     * @return integral - 积分值
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 设置积分值
     *
     * @param integral 积分值
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * 获取当前等级
     *
     * @return current_level - 当前等级
     */
    public Long getCurrentLevel() {
        return currentLevel;
    }

    /**
     * 设置当前等级
     *
     * @param currentLevel 当前等级
     */
    public void setCurrentLevel(Long currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * 获取虚拟货币数
     *
     * @return virtual_icons - 虚拟货币数
     */
    public Long getVirtualIcons() {
        return virtualIcons;
    }

    /**
     * 设置虚拟货币数
     *
     * @param virtualIcons 虚拟货币数
     */
    public void setVirtualIcons(Long virtualIcons) {
        this.virtualIcons = virtualIcons;
    }

    /**
     * 获取创建日期
     *
     * @return created_at - 创建日期
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建日期
     *
     * @param createdAt 创建日期
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取更新日期
     *
     * @return updated_at - 更新日期
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新日期
     *
     * @param updatedAt 更新日期
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取逻辑删除字段 1正常  0删除
     *
     * @return valid - 逻辑删除字段 1正常  0删除
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * 设置逻辑删除字段 1正常  0删除
     *
     * @param valid 逻辑删除字段 1正常  0删除
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}