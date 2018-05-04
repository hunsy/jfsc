package com.hunsy.pointshop.entity;

import com.hunsy.pointshop.commons.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "medal")
public class Medal extends BaseEntity {

    /**
     * 归属应用
     */
    @Column(name = "app_id")
    private Long appId;

    /**
     * 创建者（开发者）
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 对应事件id
     */
    @Column(name = "event_id")
    private Long eventId;

    /**
     * 勋章系列id
     */
    @Column(name = "serial_id")
    private Long serialId;

    /**
     * 条件名称
     */
    private String name;

    /**
     * 获取图标
     */
    private String icon;

    /**
     * 未获取图标
     */
    @Column(name = "unget_icon")
    private String ungetIcon;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 删除标识  1正常 0 删除
     */
    private Byte valid;

    private Integer getCondition;

    /**
     * 获取条件文案
     */
    @Column(name = "get_condition_words")
    private String getConditionWords;

    /**
     * 激励文案
     */
    @Column(name = "stimulate_words")
    private String stimulateWords;


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
     * 获取创建者（开发者）
     *
     * @return created_by - 创建者（开发者）
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建者（开发者）
     *
     * @param createdBy 创建者（开发者）
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取对应事件id
     *
     * @return event_id - 对应事件id
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * 设置对应事件id
     *
     * @param eventId 对应事件id
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
     * 获取条件名称
     *
     * @return name - 条件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置条件名称
     *
     * @param name 条件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取获取图标
     *
     * @return icon - 获取图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置获取图标
     *
     * @param icon 获取图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取未获取图标
     *
     * @return unget_icon - 未获取图标
     */
    public String getUngetIcon() {
        return ungetIcon;
    }

    /**
     * 设置未获取图标
     *
     * @param ungetIcon 未获取图标
     */
    public void setUngetIcon(String ungetIcon) {
        this.ungetIcon = ungetIcon;
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
     * 获取删除标识  1正常 0 删除
     *
     * @return valid - 删除标识  1正常 0 删除
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * 设置删除标识  1正常 0 删除
     *
     * @param valid 删除标识  1正常 0 删除
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }

    /**
     * 获取获取条件文案
     *
     * @return get_condition_words - 获取条件文案
     */
    public String getGetConditionWords() {
        return getConditionWords;
    }

    /**
     * 设置获取条件文案
     *
     * @param getConditionWords 获取条件文案
     */
    public void setGetConditionWords(String getConditionWords) {
        this.getConditionWords = getConditionWords;
    }

    /**
     * 获取激励文案
     *
     * @return stimulate_words - 激励文案
     */
    public String getStimulateWords() {
        return stimulateWords;
    }

    /**
     * 设置激励文案
     *
     * @param stimulateWords 激励文案
     */
    public void setStimulateWords(String stimulateWords) {
        this.stimulateWords = stimulateWords;
    }

    public Integer getGetCondition() {
        return getCondition;
    }

    public void setGetCondition(Integer getCondition) {
        this.getCondition = getCondition;
    }
}