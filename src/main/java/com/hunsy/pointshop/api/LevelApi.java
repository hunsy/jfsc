package com.hunsy.pointshop.api;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.LevelInVo;
import com.hunsy.pointshop.api.vo.LevelOutVo;
import com.hunsy.pointshop.api.vo.LevelPageItemOutVo;
import com.hunsy.pointshop.api.vo.LevelUpdateInVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.response.PageRetVo;
import com.hunsy.pointshop.commons.utils.MySecurityContextUtil;
import com.hunsy.pointshop.entity.AppDeveloper;
import com.hunsy.pointshop.entity.Level;
import com.hunsy.pointshop.service.LevelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/level")
public class LevelApi {

    @Autowired
    private LevelService levelService;


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody LevelInVo vo) throws BizException {

        Level level = new Level();
        BeanUtils.copyProperties(vo, level);
        AppDeveloper operator = MySecurityContextUtil.getDev();
        level.setCreatedBy(operator.getId());

        boolean flag = levelService.saveLevel(level);
        return ResponseEntity.ok(DataRet.success());
    }


    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody LevelUpdateInVo vo) throws BizException {
        Level level = new Level();
        BeanUtils.copyProperties(vo, level);
        boolean flag = levelService.updateLevel(level);
        return ResponseEntity.ok(DataRet.success());
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws BizException {
        Level level = levelService.findById(id);
        if (level == null) {
            throw new BizException(RetCode.LEVEL_NOT_EXIST);
        }

        level.setValid((byte) 0);
        levelService.deleteLevel(level);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) throws BizException {

        Level level = levelService.findById(id);
        if (level == null) {
            throw new BizException(RetCode.LEVEL_NOT_EXIST);
        }
        LevelOutVo ov = new LevelOutVo();
        BeanUtils.copyProperties(level, ov);
        return ResponseEntity.ok(DataRet.success(ov));
    }

    /**
     * 分页
     *
     * @return
     */
    @RequestMapping("page")
    public ResponseEntity<Object> page(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            LevelUpdateInVo params) {

        PageInfo<Level> pageInfo = levelService.findPage(pageNo, pageSize, params);
        List<LevelPageItemOutVo> vos = new ArrayList<>();
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
            pageInfo.getList().forEach(l -> {
                LevelPageItemOutVo vo = new LevelPageItemOutVo();
                BeanUtils.copyProperties(l, vo);
                vos.add(vo);
            });
        }
        PageInfo<LevelPageItemOutVo> voPageInfo = new PageInfo<>(vos);
        return ResponseEntity.ok(DataRet.success(new PageRetVo<>(voPageInfo)));
    }


}
