package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import java.util.Date;
import javax.persistence.*;

public class Level extends BaseEntity {


    private Long createdBy;
    /**
     * 归属应用
     */
    @Column(name = "app_id")
    private Long appId;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 等级名称
     */
    private String name;

    /**
     * 等级对应的图标
     */
    private String icon;

    /**
     * 等级的最低分数
     */
    @Column(name = "min_score")
    private Long minScore;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 删除标识 1正常  0删除
     */
    private Byte valid;

    /**
     * 等级描述
     */
    @Column(name = "level_words")
    private String levelWords;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取归属应用
     *
     * @return app_id - 归属应用
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置归属应用
     *
     * @param appId 归属应用
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取等级
     *
     * @return level - 等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置等级
     *
     * @param level 等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取等级名称
     *
     * @return name - 等级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置等级名称
     *
     * @param name 等级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取等级对应的图标
     *
     * @return icon - 等级对应的图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置等级对应的图标
     *
     * @param icon 等级对应的图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }


    public Long getMinScore() {
        return minScore;
    }

    public void setMinScore(Long minScore) {
        this.minScore = minScore;
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
     * 获取删除标识 1正常  0删除
     *
     * @return valid - 删除标识 1正常  0删除
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * 设置删除标识 1正常  0删除
     *
     * @param valid 删除标识 1正常  0删除
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }

    /**
     * 获取等级描述
     *
     * @return level_words - 等级描述
     */
    public String getLevelWords() {
        return levelWords;
    }

    /**
     * 设置等级描述
     *
     * @param levelWords 等级描述
     */
    public void setLevelWords(String levelWords) {
        this.levelWords = levelWords;
    }
}