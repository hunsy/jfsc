package com.hunsy.pointshop.commons.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 勋章类型
 */
public enum ModalType {
    GROWTH_EVENT(1, "成长事件"),
    INTEGRAL_EVENT(2, "积分事件"),
    GOLD_EVENT(3, "金币事件");


    private Integer type;
    private String display;

    ModalType(Integer type, String display) {
        this.type = type;
        this.display = display;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public static List<Map<String, Object>> getTypes() {
        ModalType[] types = ModalType.values();
        List<Map<String, Object>> list = new ArrayList<>();
        for (ModalType type : types) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", type.getType());
            map.put("display", type.getDisplay());
            list.add(map);
        }
        return list;
    }
}
