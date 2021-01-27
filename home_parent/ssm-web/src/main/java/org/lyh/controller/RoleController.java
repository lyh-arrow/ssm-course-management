package org.lyh.controller;

import org.lyh.bean.*;
import org.lyh.service.MenuService;
import org.lyh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    //根据条件查询所有角色
    @PostMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> allRole = roleService.findAllRole(role);
        return new ResponseResult(true,200,"查询角色成功",allRole);
    }

    //查询所有菜单信息
    @GetMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);
        Map<String,Object> map=new HashMap<>();
        map.put("parentMenuList",subMenuListByPid);
        return new ResponseResult(true,200,"响应成功",map);
    }

    //根据角色id查询关联的菜单id
    @GetMapping("/findMenuByRoleId/{roleId}")
    public ResponseResult findMenuByRoleId(@PathVariable("roleId") Integer roleId){
        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(true,200,"响应成功",menuByRoleId);
    }

    //为角色分配菜单
    @PostMapping("/roleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.RoleContextMenu(roleMenuVo);
        return new ResponseResult(true,200,"分配菜单信息成功",null);
    }

    //删除角色
    @GetMapping("/deleteRole/{id}")
    public ResponseResult deleteRole(@PathVariable("id") Integer id){
        roleService.deleteRole(id);
        return new ResponseResult(true,200,"删除角色成功",null);
    }

    //根据角色id显示该角色所拥有的资源
    @GetMapping("/findResourceListByRoleId/{roleId}")
    public ResponseResult findResourceListByRoleId(@PathVariable("roleId") Integer roleId){
        List<ResourceCategory> resourceList = roleService.findResourceListByRoleId(roleId);
        return new ResponseResult(true,200,"响应成功",resourceList);
    }
    
    //为角色分配资源
    @PostMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVo roleResourceVo){
        roleService.roleContextResource(roleResourceVo);
        return new ResponseResult(true,200,"分配资源成功",null);
    }


}
