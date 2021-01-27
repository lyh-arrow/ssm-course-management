package org.lyh.service;


import org.lyh.bean.ResourceCategory;
import org.lyh.bean.Role;
import org.lyh.bean.RoleMenuVo;
import org.lyh.bean.RoleResourceVo;

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

    //根据角色id查询相关的回显相关的资源
    List<ResourceCategory> findResourceListByRoleId(Integer roleId);

    //为角色分配资源
    void roleContextResource(RoleResourceVo roleResourceVo);
}
