package org.lyh.controller;


import com.github.pagehelper.PageInfo;
import org.lyh.bean.ResponseResult;
import org.lyh.bean.Role;
import org.lyh.bean.User;
import org.lyh.bean.UserVo;
import org.lyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //用户条件及分页查询
    @PostMapping("/findAllUserByPage")
    public ResponseResult responseResult(@RequestBody UserVo userVo){
        PageInfo<User> pageInfo = userService.findAllUserByPage(userVo);
        return new ResponseResult(true,200,"查询成功",pageInfo);
    }

    //登录
    @GetMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User user2 = userService.login(user);
        if(user2==null){
            return new ResponseResult(false,400,"用户名或密码错误",null);
        }
        String accessToken= UUID.randomUUID().toString();
        HttpSession session = request.getSession();
        session.setAttribute("access_token",accessToken);
        session.setAttribute("user_id",user2.getId());
        Map<String,Object> map=new HashMap<>();
        map.put("access_token",accessToken);
        map.put("user_id",user2.getId());
        map.put("user",user2);
        return new ResponseResult(true,1,"登录成功",map);
    }

    // 根据用户id查询所拥有的角色
    @GetMapping("/findUserRoleById/{userId}")
    public ResponseResult findUserRoleById(@PathVariable("userId") Integer userId){
        List<Role> userRole = userService.findUserRoleById(userId);
        return new ResponseResult(true,200,"响应成功",userRole);

    }

    //分配角色
    @PostMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);
        return new ResponseResult(true,200,"响应成功",null);
    }

    //获取用户权限，进行菜单动态展示
    @GetMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        String access_token = (String) request.getSession().getAttribute("access_token");
        if(authorization.equals(access_token)){
            Integer user_id = (Integer)request.getSession().getAttribute("user_id");
            return userService.getUserPermissions(user_id);
        }
        return new ResponseResult(false,400,"获取菜单信息失败",null);
    }

}
