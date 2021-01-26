package org.lyh.service;


import org.lyh.bean.Role;
import org.lyh.bean.RoleMenuVo;

import java.util.List;

public interface RoleService {

    //角色列表查询&条件查询
    List<Role> findAllRole(Role role);

    //根据角色id查询关联的菜单id
    List<Integer> findMenuByRoleId(Integer roleId);

    //为角色分配菜单
    void RoleContextMenu(RoleMenuVo roleMenuVo);

    //删除角色
    void deleteRole(Integer id);
}
