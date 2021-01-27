package org.lyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lyh.bean.*;

import java.util.List;

public interface RoleMapper {

    //角色列表查询&条件查询
    List<Role> findAllRole(Role role);

    //根据角色id查询关联的菜单id
    @Select("SELECT m.id FROM roles r INNER JOIN role_menu_relation rm ON r.id = rm.role_id\n" +
            "\t                     INNER JOIN menu m ON m.id = rm.menu_id WHERE r.id =#{id}")
    List<Integer> findMenuByRoleId(Integer roleId);

    //根据角色id删除角色关联菜单信息
    void deleteRoleContextMenu(Integer roleId);

    //为角色分配菜单信息
    void RoleContextMenu(Role_menu_relation roleMenuRelation);

    //删除角色
    @Delete("delete from roles where id = #{id}")
    void deleteRole(Integer id);


    //根据角色id查询相关联的资源信息
    List<Resource> findResourceListByRoleId(Integer roleId);

    //根据资源角色id查询相关的资源分类信息
    List<ResourceCategory> findResourceCategoryListByResourceId(Integer roleId);

    //根据角色id删除相关资源 角色-资源信息表
    @Delete("delete from role_resource_relation where role_id = #{roleId}")
    void deleteRoleContextResource(Integer roleId);

    //添加相关 资源角色-资源信息表
    void roleContextResource(RoleResourceRelation roleResourceRelation);
}
