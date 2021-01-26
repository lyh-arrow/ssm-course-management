package org.lyh.service;


import com.github.pagehelper.PageInfo;

import org.lyh.bean.ResponseResult;
import org.lyh.bean.Role;
import org.lyh.bean.User;
import org.lyh.bean.UserVo;

import java.util.List;

public interface UserService {

    //用户分页及多条件查询
    PageInfo<User> findAllUserByPage(UserVo userVo);

    //根据用户名查询用户
    User login(User user) throws Exception;

    //根据用户id查询所拥有的角色
    List<Role> findUserRoleById(Integer userId);

    //分配角色
    void userContextRole(UserVo userVo);

    //获取用户权限，进行动态菜单展示
    ResponseResult getUserPermissions(Integer userId);
}
