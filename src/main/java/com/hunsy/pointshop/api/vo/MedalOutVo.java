package com.hunsy.pointshop.api.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class MedalOutVo implements Serializable {

    private Long id;
    /**
     * 归属应用
     */
    private Long appId;

    private Long serialId;

    /**
     * 事件系列码
     */
    private Long eventId;

    private String eventName;

    /**
     * 条件名称
     */
    @Size(max = 16, min = 3)
    private String name;

    private String icon;

    private String ungetIcon;

    /**
     * 获取条件(多少次事件码可以获取这个事件)
     */
    @Min(0)
    private Integer getCondition;
    /**
     * 获取条件文案
     */
    private String getConditionWords;

    /**
     * 激励文案
     */
    private String stimulateWords;

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

    public String getSerialId() {
        return serialId + "";
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public String getEventId() {
        return eventId + "";
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    public String getUngetIcon() {
        return ungetIcon;
    }

    public void setUngetIcon(String ungetIcon) {
        this.ungetIcon = ungetIcon;
    }

    public Integer getGetCondition() {
        return getCondition;
    }

    public void setGetCondition(Integer getCondition) {
        this.getCondition = getCondition;
    }

    public String getGetConditionWords() {
        return getConditionWords;
    }

    public void setGetConditionWords(String getConditionWords) {
        this.getConditionWords = getConditionWords;
    }

    public String getStimulateWords() {
        return stimulateWords;
    }

    public void setStimulateWords(String stimulateWords) {
        this.stimulateWords = stimulateWords;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
