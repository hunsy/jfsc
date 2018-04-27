package com.hunsy.pointshop.api.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ModalSerialInVo implements Serializable {

    @NotNull
    private Long appId;
    /**
     * 名称
     */
    @NotNull
    @Size(min = 3, max = 16)
    private String name;

    @NotNull
    @Min(1)
    @Max(3)
    private Byte type;

    /**
     * 上下架状态 1上架 0下架
     */
    private Byte status = 0;

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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
