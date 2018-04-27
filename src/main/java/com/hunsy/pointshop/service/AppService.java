package com.hunsy.pointshop.service;

import com.hunsy.pointshop.commons.constants.AppRole;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.App;
import com.hunsy.pointshop.entity.AppDev;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppService extends BaseService<App> {


    @Autowired
    private AppDevService appDevService;

    /**
     * 新增应用
     *
     * @param app
     * @return
     */
    public boolean saveApp(App app) {

        app.setAppKey(RandomStringUtils.randomAlphabetic(16));
        app.setAppSecret(RandomStringUtils.randomAlphanumeric(32));
        boolean flag = super.insertSelective(app) == 1;
        if (flag) {
            AppDev ad = new AppDev();
            ad.setAppId(app.getId());
            ad.setDevId(app.getDevId());
            ad.setRole(AppRole.OWNER.getName());
            appDevService.saveAppDev(ad);
        }
        return flag;
    }

    /**
     * 主键查询
     *
     * @param id 应用id
     * @return
     */
    public App findById(Long id) {

        App app = new App();
        app.setId(id);
        app.setValid(1);
        return super.selectOne(app);
    }

    /**
     * 根据id列表查询应用。
     *
     * @param appIds 应用的ID列表
     * @return List
     */
    public List<App> findByIds(List<Long> appIds) {
        Example example = new Example(App.class);
        example.createCriteria()
                .andIn("id", appIds)
                .andEqualTo("valid", 1);
        return super.selectByExample(example);
    }


}
