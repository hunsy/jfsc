package com.hunsy.pointshop.api;

import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.*;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.response.DataRet;
import com.hunsy.pointshop.commons.response.PageRetVo;
import com.hunsy.pointshop.entity.Menu;
import com.hunsy.pointshop.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/menu")
public class MenuApi {

    @Autowired
    private MenuService menuService;


    @PostMapping
    public ResponseEntity<Object> saveMenu(@RequestBody MenuInVo vo) {

        Menu menu = new Menu();
        BeanUtils.copyProperties(vo, menu);
        menuService.saveMenu(menu);

        return ResponseEntity.ok(DataRet.success());
    }


    @PutMapping
    public ResponseEntity<Object> updateMenu(@RequestBody MenuUpdateInVo vo) throws BizException {

        Menu menu = new Menu();
        BeanUtils.copyProperties(vo, menu);
        menuService.updateMenu(menu);
        return ResponseEntity.ok(DataRet.success());
    }


    @GetMapping(value = "page")
    public ResponseEntity<Object> page(MenuPageParamInVo vo) {

//        MenuPageParamInVo vo = new MenuPageParamInVo();

        PageInfo<MenuPageItemOutVo> voPageInfo = menuService.findPage(vo);

        return ResponseEntity.ok(DataRet.success(new PageRetVo<>(voPageInfo)));
    }


    @GetMapping(value = "tree/{parentId}")
    public ResponseEntity<Object> page(@PathVariable("parentId") Long parentId) throws BizException {

//        MenuPageParamInVo vo = new MenuPageParamInVo();
        List<MenuTreeItemOutVo> trees = menuService.findTree(parentId);
        return ResponseEntity.ok(DataRet.success(trees));
    }

}
