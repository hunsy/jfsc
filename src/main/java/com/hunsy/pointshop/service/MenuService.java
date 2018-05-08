package com.hunsy.pointshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunsy.pointshop.api.vo.MenuPageItemOutVo;
import com.hunsy.pointshop.api.vo.MenuPageParamInVo;
import com.hunsy.pointshop.api.vo.MenuTreeItemOutVo;
import com.hunsy.pointshop.commons.code.RetCode;
import com.hunsy.pointshop.commons.exception.BizException;
import com.hunsy.pointshop.commons.service.BaseService;
import com.hunsy.pointshop.entity.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService extends BaseService<Menu> {


    public boolean saveMenu(Menu menu) {

        return super.insertSelective(menu) == 1;
    }


    public boolean updateMenu(Menu menu) throws BizException {

        Menu dbMenu = findById(menu.getId());
        if (dbMenu == null) {
            throw new BizException(RetCode.MENU_NOT_EXIST);
        }

        return super.updatedSelective(menu) == 1;
    }


    public Menu findById(Long id) {

        Menu menu = new Menu();
        menu.setValid((byte) 1);
        menu.setId(id);
        return super.selectOne(menu);
    }


    public List<MenuTreeItemOutVo> findTree(Long parentId) throws BizException {

        Menu menu = findById(parentId);
        if (menu == null) {
            throw new BizException(RetCode.MENU_NOT_EXIST);
        }

        MenuTreeItemOutVo tvo = new MenuTreeItemOutVo();
        BeanUtils.copyProperties(menu, tvo);
        List<MenuTreeItemOutVo> nextMenus = findForTree(tvo);
        tvo.setChildren(nextMenus);

//        List<Menu> menus = findByParentId(parentId);
//        List<MenuTreeItemOutVo> vos = new ArrayList<>();
//        if (menus != null && !menus.isEmpty()) {
//            menus.forEach(menu -> {
//                MenuTreeItemOutVo tvo = new MenuTreeItemOutVo();
//                BeanUtils.copyProperties(menu, tvo);
//                List<MenuTreeItemOutVo> nextMenus = findForTree(tvo);
//                tvo.setChildren(nextMenus);
//                vos.add(tvo);
//            });
//        }
        List<MenuTreeItemOutVo> retVo = new ArrayList<>();
        retVo.add(tvo);
        return retVo;
    }

    private List<MenuTreeItemOutVo> findForTree(MenuTreeItemOutVo vo) {

        List<Menu> menus = findByParentId(vo.getId());
        List<MenuTreeItemOutVo> vos = new ArrayList<>();
        if (menus != null && !menus.isEmpty()) {
            menus.forEach(menu -> {
                MenuTreeItemOutVo tvo = new MenuTreeItemOutVo();
                BeanUtils.copyProperties(menu, tvo);
                List<MenuTreeItemOutVo> nextMenus = findForTree(tvo);
//                if (nextMenus != null && !nextMenus.isEmpty()) {
                    tvo.setChildren(nextMenus);
//                }
                vos.add(tvo);
            });

            vo.setChildren(vos);
        }
        return vos;
    }


    /**
     * 子菜单
     *
     * @param parentId
     * @return
     */
    public List<Menu> findByParentId(Long parentId) {

        Example example = new Example(Menu.class);
        example.createCriteria()
                .andEqualTo("valid", 1)
                .andEqualTo("parentId", parentId);
        example.orderBy("name").asc();
        return super.selectByExample(example);
    }


    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    public PageInfo<MenuPageItemOutVo> findPage(MenuPageParamInVo vo) {

        Example example = new Example(Menu.class);
        example.createCriteria()
                .andIsNull("parentId")
                .andEqualTo("valid", 1);
        example.orderBy("name").asc();
        PageHelper.startPage(vo.getPageNo(), vo.getPageNo() * vo.getPageSize());
        List<Menu> menus = super.selectByExample(example);
        List<MenuPageItemOutVo> vos = new ArrayList<>();
        if (menus != null && !menus.isEmpty()) {
            menus.forEach(menu -> {
                MenuPageItemOutVo v = new MenuPageItemOutVo();
                BeanUtils.copyProperties(menu, v);
                vos.add(v);
            });
        }
        return new PageInfo<>(vos);
    }


}
