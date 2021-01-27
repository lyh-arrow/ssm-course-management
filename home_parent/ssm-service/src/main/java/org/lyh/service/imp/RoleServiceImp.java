package org.lyh.service.imp;

import org.lyh.bean.*;
import org.lyh.mapper.RoleMapper;
import org.lyh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ResourceCategory> findResourceListByRoleId(Integer roleId) {
        List<ResourceCategory> resourceCategoryList = roleMapper.findResourceCategoryListByResourceId(roleId);
        List<Resource> resourceList = roleMapper.findResourceListByRoleId(roleId);
        resourceCategoryList.forEach(resourceCategory -> {
            List<Resource> resources=resourceList.stream().filter(resource ->resource.getCategoryId().equals(resourceCategory.getId())).collect(Collectors.toList());
            resourceCategory.setResourceList(resources);
        });
        return resourceCategoryList;
    }

    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {
        roleMapper.deleteRoleContextResource(roleResourceVo.getRoleId());
        LocalDateTime now=LocalDateTime.now();
        roleResourceVo.getResourceIdList().forEach(resourceId->{
            RoleResourceRelation resourceRelation=new RoleResourceRelation();
            resourceRelation.setRoleId(roleResourceVo.getRoleId());
            resourceRelation.setResourceId(resourceId);
            resourceRelation.setCreatedTime(now);
            resourceRelation.setUpdatedTime(now);
            resourceRelation.setCreatedBy("system");
            resourceRelation.setUpdatedBy("system");
            roleMapper.roleContextResource(resourceRelation);
        });

    }
}
