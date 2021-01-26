package org.lyh.service.imp;

import org.lyh.bean.Role;
import org.lyh.bean.RoleMenuVo;
import org.lyh.bean.Role_menu_relation;
import org.lyh.mapper.RoleMapper;
import org.lyh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        LocalDateTime now = LocalDateTime.now();
        roleMenuVo.getMenuIdList().forEach(menuId->{
            Role_menu_relation roleMenuRelation=new Role_menu_relation();
            roleMenuRelation.setRoleId(roleMenuVo.getRoleId());
            roleMenuRelation.setMenuId(menuId);
            roleMenuRelation.setCreatedTime(now);
            roleMenuRelation.setUpdatedTime(now);
            roleMenuRelation.setCreatedBy("system");
            roleMenuRelation.setUpdatedby("system");
            roleMapper.RoleContextMenu(roleMenuRelation);
        });
    }

    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteRoleContextMenu(id);
        roleMapper.deleteRole(id);
    }
}
