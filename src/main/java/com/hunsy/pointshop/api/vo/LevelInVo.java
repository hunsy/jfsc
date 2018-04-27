package com.hunsy.pointshop.api.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class LevelInVo implements Serializable {

    @NotNull
    private Long appId;

    /**
     * 等级名称
     */
    @NotNull
    private String name;

    /**
     * 等级对应的图标
     */
    private String icon;

    /**
     * 等级的最低分数
     */
    @Min(0)
    @NotNull
    private Long minScore;
    /**
     * 等级描述
     */
    private String levelWords;


    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getMinScore() {
        return minScore;
    }

    public void setMinScore(Long minScore) {
        this.minScore = minScore;
    }

    public String getLevelWords() {
        return levelWords;
    }

    public void setLevelWords(String levelWords) {
        this.levelWords = levelWords;
    }
}
