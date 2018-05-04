package com.hunsy.pointshop.service;

import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEventService extends BaseService<UserEvents> {

    @Autowired
    private UserEventsLogService userEventsLogService;
    @Autowired
    private MedalSerialService medalSerialService;
    @Autowired
    private MedalService medalService;
    @Autowired
    private EventService eventService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LevelService levelService;

    /**
     * 新增事件
     *
     * @param events
     * @return
     */
    public boolean saveEvent(UserEvents events) {

        UserEvents dbEvent = findByAccount(events.getAppId(), events.getSerialId(), events.getUserAccount());
        boolean flag = false;
        if (dbEvent == null) {
            flag = super.insertSelective(events) == 1;
        } else {
            dbEvent.setTimes(dbEvent.getTimes() + events.getTimes());
            flag = super.updatedSelective(dbEvent) == 1;
        }

        if (flag) {
            //新增日志
            UserEventsLog eventsLog = new UserEventsLog();
            eventsLog.setAppId(events.getAppId());
            eventsLog.setSerialId(events.getSerialId());
            eventsLog.setTimes(events.getTimes());
            userEventsLogService.saveLog(eventsLog);

            MedalSerial medalSerial = medalSerialService.findById(events.getSerialId());
            Medal medal = medalService.findBySerialAndCondition(events.getSerialId(), dbEvent.getTimes());
            //获取勋章
            if (medal != null) {
                UserInfo userInfo = userInfoService.findByAccount(events.getAppId(), events.getUserAccount());

                Event event = eventService.findById(medal.getEventId());
                //成长
                if (medalSerial.getType() == 1) {
                    userInfo.setScore(userInfo.getScore() + event.getScore());
                    Level level = levelService.findByScore(events.getAppId(), userInfo.getScore());

                    if (level != null) {
                        if (userInfo.getCurrentLevel() != level.getLevel()) {
                            userInfo.setCurrentLevel(level.getLevel());
                        }
                    }


                }

            }

        }
        return flag;
    }


    /**
     * 查询是否已经存在事件了
     *
     * @param appId
     * @param serialId
     * @param userAccount
     * @return
     */
    private UserEvents findByAccount(Long appId, Long serialId, String userAccount) {
        UserEvents events = new UserEvents();
        events.setAppId(appId);
        events.setSerialId(serialId);
        events.setUserAccount(userAccount);
        events.setValid((byte) 1);
        return super.selectOne(events);
    }


}
