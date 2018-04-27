package com.hunsy.pointshop.api.vo;


public class UserInfoOutVo {

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
}
