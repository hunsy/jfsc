package com.hunsy.pointshop.api;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.*;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.response.PageRetVo;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.Event;
import com.hunsy.pointshop.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/event")
public class EventApi {

    @Autowired
    private EventService eventService;


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody EventInVo vo) {

        Event event = new Event();
        BeanUtils.copyProperties(vo, event);
        AppDeveloper operator = MySecurityContextUtil.getDev();
        event.setCreatedBy(operator.getId());
        boolean flag = eventService.saveEvent(event);
        return ResponseEntity.ok(DataRet.success());
    }


    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody EventUpdateInVo vo) {

        Event event = new Event();
        BeanUtils.copyProperties(vo, event);
        boolean flag = eventService.updateEvent(event);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) throws BizException {

        Event event = eventService.findById(id);
        if (event == null) {
            throw new BizException(RetCode.EVENT_NOT_EXIST);
        }
        EventOutVo vo = new EventOutVo();
        BeanUtils.copyProperties(event, vo);
        return ResponseEntity.ok(DataRet.success(vo));
    }

    @GetMapping("list")
    public ResponseEntity<Object> list(Long appId, String name) {

        List<Event> events = eventService.findListByName(appId, name);
        List<EventPageItemOutVo> vos = new ArrayList<>();
        if (events != null && !events.isEmpty()) {
            events.forEach(event -> {
                EventPageItemOutVo vo = new EventPageItemOutVo();
                BeanUtils.copyProperties(event, vo);
                vos.add(vo);
            });
        }
        return ResponseEntity.ok(DataRet.success(vos));
    }


    @GetMapping("page")
    public ResponseEntity<Object> page(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            LevelUpdateInVo params) {

        PageInfo<Event> pageInfo = eventService.findPage(pageNo, pageSize, params);
        List<EventPageItemOutVo> vos = new ArrayList<>();
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
            pageInfo.getList().forEach(e -> {
                EventPageItemOutVo vo = new EventPageItemOutVo();
                BeanUtils.copyProperties(e, vo);
                vos.add(vo);
            });
        }
        PageInfo<EventPageItemOutVo> voPageInfo = new PageInfo(vos);
        return ResponseEntity.ok(DataRet.success(new PageRetVo(voPageInfo)));
    }


}
