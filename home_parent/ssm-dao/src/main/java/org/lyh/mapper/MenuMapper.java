package org.lyh.mapper;

import org.apache.ibatis.annotations.Select;
import org.lyh.bean.Menu;

import java.util.List;

public interface MenuMapper {

    //查询所有父子菜单信息
    List<Menu> findSubMenuListByPid(Integer id);

    //查询所有菜单信息
    @Select("select * from menu")
    List<Menu> findAllMenu();

    //根据菜单id查询菜单
    @Select("select * from menu where id = #{id}")
    Menu findMenuById(Integer id);
}
