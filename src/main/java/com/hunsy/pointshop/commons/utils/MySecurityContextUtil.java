package com.hunsy.pointshop.commons.utils;

import com.hunsy.pointshop.entity.AppDeveloper;
import org.springframework.security.core.context.SecurityContextHolder;

public class MySecurityContextUtil {


    /**
     * 获取开发者
     *
     * @return
     */
    public static AppDeveloper getDev() {
        return (AppDeveloper) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
