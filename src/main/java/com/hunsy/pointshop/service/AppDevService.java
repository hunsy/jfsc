package com.hunsy.pointshop.service;

import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.AppDev;
import com.hunsy.pointshop.entity.dto.AppDevDto;
import com.hunsy.pointshop.mapper.AppDevMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 开发者与应用的关系
 */
@Service
public class AppDevService extends BaseService<AppDev> {

    @Autowired
    private AppDevMapper appDevMapper;

    /**
     * 新增开发者与应用关系
     *
     * @param appDev
     * @return
     */
    public boolean saveAppDev(AppDev appDev) {

        return super.insertSelective(appDev) == 1;
    }

    /**
     * 查询开发者与应用的关系
     *
     * @param appId
     * @param devId
     * @return
     */
    public AppDev findByAppAndDev(Long appId, Long devId) {
        AppDev dev = new AppDev();
        dev.setAppId(appId);
        dev.setDevId(devId);
        dev.setValid(1);
        return super.selectOne(dev);
    }

    /**
     * 开发者下的应用
     *
     * @param developerId 开发者id
     * @return
     */
    public List<AppDevDto> findByDeveloper(Long developerId) {

        AppDevDto dto = new AppDevDto();
        dto.setDevId(developerId);
        List<AppDevDto> devDtos = appDevMapper.findList(dto);
        return devDtos;
    }

    /**
     * 获取应用下的开发者
     *
     * @param appId
     * @return
     */
    public List<AppDevDto> findByApp(Long appId) {
        AppDevDto dto = new AppDevDto();
        dto.setAppId(appId);
        List<AppDevDto> devDtos = appDevMapper.findList(dto);
        return devDtos;
    }

    /**
     * 设置开发者下的默认应用
     *
     * @param id
     */
    public void setDef(Long id) {
        AppDev appDev = new AppDev();
        appDev.setValid(1);
        appDev.setId(id);
        AppDev dbAd = super.selectOne(appDev);
        if (dbAd != null) {
            AppDev dad = new AppDev();
            dad.setIsDefault(0);
            Example example = new Example(AppDev.class);
            example.createCriteria()
                    .andEqualTo("devId", dbAd.getDevId());
            super.updatedByExampleSelective(dad, example);
            dbAd.setIsDefault(1);
            super.updatedSelective(dbAd);
        }
    }
}
