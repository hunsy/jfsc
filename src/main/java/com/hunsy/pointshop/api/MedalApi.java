package com.hunsy.pointshop.api;

import com.hunsy.pointshop.api.vo.MedalInVo;
import com.hunsy.pointshop.api.vo.MedalItemOutVo;
import com.hunsy.pointshop.api.vo.MedalOutVo;
import com.hunsy.pointshop.api.vo.MedalUpdateInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.Event;
import com.hunsy.pointshop.entity.Medal;
import com.hunsy.pointshop.service.EventService;
import com.hunsy.pointshop.service.MedalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/medal")
public class MedalApi {

    @Autowired
    private MedalService medalService;
    @Autowired
    private EventService eventService;

    /**
     * 新增
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody MedalInVo vo) throws BizException {

        AppDeveloper operator = MySecurityContextUtil.getDev();
        Medal medal = new Medal();
        BeanUtils.copyProperties(vo, medal);
        medal.setCreatedBy(operator.getId());
        boolean flag = medalService.saveMedal(medal);
        return ResponseEntity.ok(DataRet.success());
    }

    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody MedalUpdateInVo vo) throws BizException {

        Medal medal = new Medal();
        BeanUtils.copyProperties(vo, medal);
        boolean flag = medalService.updateMedal(medal);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) throws BizException {
        Medal medal = medalService.findById(id);
        if (medal == null) {
            throw new BizException(RetCode.MEDAL_NOT_EXIST);
        }
        MedalOutVo vo = new MedalOutVo();
        BeanUtils.copyProperties(medal, vo);
        if (medal.getEventId() != null) {
            Event event = eventService.findById(medal.getEventId());
            if (event != null) {
                vo.setEventName(event.getName());
            }
        }
        return ResponseEntity.ok(DataRet.success(vo));
    }

    @GetMapping(value = "list/{serialId}")
    public ResponseEntity<Object> list(@PathVariable("serialId") Long serialId) throws BizException {
        List<Medal> conditions = medalService.findListBySerialId(serialId);
        List<MedalItemOutVo> vos = new ArrayList<>();
        if (conditions != null && !conditions.isEmpty()) {
            conditions.forEach(condition -> {
                MedalItemOutVo vo = new MedalItemOutVo();
                BeanUtils.copyProperties(condition, vo);
                vos.add(vo);
            });
        }
        return ResponseEntity.ok(DataRet.success(vos));
    }


}
