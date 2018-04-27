package com.hunsy.pointshop.api.vo;

public class LevelOutVo {

    private Long id;

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
    private Long minScore;
    /**
     * 等级描述
     */
    private String levelWords;

    public String getId() {
        return id + "";
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public String getMinScore() {
        return minScore + "";
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
