package com.hunsy.pointshop.api;

import com.hunsy.pointshop.api.vo.ModalInVo;
import com.hunsy.pointshop.api.vo.ModalItemOutVo;
import com.hunsy.pointshop.api.vo.ModalOutVo;
import com.hunsy.pointshop.api.vo.ModalUpdateInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.Event;
import com.hunsy.pointshop.entity.Modal;
import com.hunsy.pointshop.service.EventService;
import com.hunsy.pointshop.service.ModalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/modal")
public class ModalApi {

    @Autowired
    private ModalService modalService;
    @Autowired
    private EventService eventService;

    /**
     * 新增
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ModalInVo vo) {

        AppDeveloper operator = MySecurityContextUtil.getDev();
        Modal modal = new Modal();
        BeanUtils.copyProperties(vo, modal);
        modal.setCreatedBy(operator.getId());
        boolean flag = modalService.saveModal(modal);
        return ResponseEntity.ok(DataRet.success());
    }

    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody ModalUpdateInVo vo) {

        Modal modal = new Modal();
        BeanUtils.copyProperties(vo, modal);
        boolean flag = modalService.updateModal(modal);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) throws BizException {
        Modal modal = modalService.findById(id);
        if (modal == null) {
            throw new BizException(RetCode.MODAL_NOT_EXIST);
        }
        ModalOutVo vo = new ModalOutVo();
        BeanUtils.copyProperties(modal, vo);
        if (modal.getEventId() != null) {
            Event event = eventService.findById(modal.getEventId());
            if (event != null) {
                vo.setEventName(event.getName());
            }
        }
        return ResponseEntity.ok(DataRet.success(vo));
    }

    @GetMapping(value = "list/{serialId}")
    public ResponseEntity<Object> list(@PathVariable("serialId") Long serialId) throws BizException {
        List<Modal> conditions = modalService.findListBySerialId(serialId);
        List<ModalItemOutVo> vos = new ArrayList<>();
        if (conditions != null && !conditions.isEmpty()) {
            conditions.forEach(condition -> {
                ModalItemOutVo vo = new ModalItemOutVo();
                BeanUtils.copyProperties(condition, vo);
                vos.add(vo);
            });
        }
        return ResponseEntity.ok(DataRet.success(vos));
    }


}
