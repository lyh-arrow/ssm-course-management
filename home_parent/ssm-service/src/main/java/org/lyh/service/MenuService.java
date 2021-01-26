package org.lyh.service;


import org.lyh.bean.Menu;

import java.util.List;

public interface MenuService {

    //查询所有父子菜单信息
    List<Menu> findSubMenuListByPid(Integer id);

    //查询所有菜单信息
    List<Menu> findAllMenu();

    //更加菜单id查询菜单
    Menu findMenuById(Integer id);
}
