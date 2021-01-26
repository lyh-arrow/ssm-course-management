package org.lyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lyh.bean.*;

import java.util.List;

public interface UserMapper {

    //用户分页及多条件查询
    List<User> findAllUserByPage(UserVo userVo);
    
    //根据用户名查询用户
    @Select("select * from user where phone = #{phone}")
    User login(User user);

    //根据用户id查询所拥有的角色
    List<Role> findUserRoleById(Integer userId);

    //根据用户id删除中间表
    @Delete("delete from user_role_relation where user_id = #{userid}")
    void deleteUserContextRole(Integer userId);

    //分配角色
    @Insert(" insert into user_role_relation values(null,#{userId},#{roleId},#{createdTime},#{updatedTime},#{createdBy},#{updatedby})")
    void userContextRole(User_Role_relation userRoleRelation);

    //根据角色ID，查询角色所拥有的父级菜单（-1）
    List<Menu> findParentMenuByRoleId(List<Integer> ids);

    //根据PID，查询子菜单信息
    List<Menu> findSubMenuByPid(Integer pId);

    //获取用户拥有的资源权限信息
    List<Resource> findResourceByRoleId(List<Integer> ids);

}
