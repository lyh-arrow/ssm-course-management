package org.lyh.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lyh.bean.*;
import org.lyh.mapper.UserMapper;
import org.lyh.service.UserService;
import org.lyh.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUserByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(), userVo.getPageSize());
        List<User> allUserByPage = userMapper.findAllUserByPage(userVo);
        return new PageInfo<>(allUserByPage);
    }

    @Override
    public User login(User user) throws Exception {
        User user2 = userMapper.login(user);
        if(user2!=null&& Md5.verify(user.getPassword(),Md5.md5key,user2.getPassword())){
            return user2;
        }
        return null;
    }

    @Override
    public List<Role> findUserRoleById(Integer userId) {
        return userMapper.findUserRoleById(userId);
    }

    @Override
    public void userContextRole(UserVo userVo) {
        userMapper.deleteUserContextRole(userVo.getUserId());
        LocalDateTime now = LocalDateTime.now();
        userVo.getRoleIdList().forEach(roleId ->{
            User_Role_relation userRoleRelation=new User_Role_relation();
            userRoleRelation.setRoleId(roleId);
            userRoleRelation.setUserId(userVo.getUserId());
            userRoleRelation.setCreatedTime(now);
            userRoleRelation.setUpdatedTime(now);
            userRoleRelation.setCreatedBy("system");
            userRoleRelation.setUpdatedby("system");
            userMapper.userContextRole(userRoleRelation);
        });
    }

    @Override
    public ResponseResult getUserPermissions(Integer userId) {
        List<Role> roleList = userMapper.findUserRoleById(userId);
        List<Integer> roleIds=new ArrayList<>();
        roleList.forEach(role->{
           roleIds.add(role.getId());
        });
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(roleIds);
        parentMenu.forEach(menu -> {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getParentId());
            menu.setSubMenuList(subMenu);
        });
        List<Resource> resourceRole = userMapper.findResourceByRoleId(roleIds);
        Map<String,Object> map=new HashMap<>();
        map.put("menuList",parentMenu);
        map.put("resourceList",resourceRole);
        return new ResponseResult(true,200,"响应成功",map);
    }
}
