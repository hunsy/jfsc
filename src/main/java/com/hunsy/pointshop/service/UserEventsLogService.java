package com.hunsy.pointshop.service;

import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.UserEventsLog;
import org.springframework.stereotype.Service;

@Service
public class UserEventsLogService extends BaseService<UserEventsLog> {


    /**
     * @param log
     * @return
     */
    public boolean saveLog(UserEventsLog log) {

        return super.insertSelective(log) == 1;
    }

}
