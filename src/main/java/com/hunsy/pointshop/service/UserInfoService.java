package com.hunsy.pointshop.service;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserInfoService extends BaseService<UserInfo> {


    public boolean saveInfo(UserInfo userInfo) {

        return super.insertSelective(userInfo) == 1;
    }

    public boolean updateInfo(UserInfo userInfo) {

        return super.updatedSelective(userInfo) == 1;
    }


    public UserInfo findById(Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setValid((byte) 1);
        userInfo.setId(id);
        return super.selectOne(userInfo);
    }

    public PageInfo<UserInfo> findPage(Integer pageNo, Integer pageSize, UserInfo params) {

        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria()
                .andEqualTo("appId", params.getAppId())
                .andEqualTo("valid", 1);
        if (StringUtils.isNotEmpty(params.getUserAccount())) {
            criteria.andEqualTo("userAccount", params.getUserAccount());
        }

        example.orderBy("updatedAt").desc();
        return super.selectByWhere(example, pageNo, pageSize);
    }

    public UserInfo findByAccount(Long appId, String userAccount) {

        UserInfo userInfo = new UserInfo();
        userInfo.setAppId(appId);
        userInfo.setUserAccount(userAccount);
        userInfo.setValid((byte) 1);
        return super.selectOne(userInfo);
    }
}
