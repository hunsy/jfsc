package com.hunsy.pointshop.api.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserInfoPageItemOutVo {

    private Long id;
    private Long appId;
    private String userAccount;
    private String nickName;
    /**
     * 获取的勋章数
     */
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
    private Long currentLevel;

    /**
     * 虚拟货币数
     */
    private Long virtualIcons;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;

    public String getId() {
        return id + "";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId + "";
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

    public Integer getMedalNum() {
        return medalNum;
    }

    public void setMedalNum(Integer medalNum) {
        this.medalNum = medalNum;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Long getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Long currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getVirtualIcons() {
        return virtualIcons + "";
    }

    public void setVirtualIcons(Long virtualIcons) {
        this.virtualIcons = virtualIcons;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
