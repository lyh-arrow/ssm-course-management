package org.lyh.controller;


import com.mysql.fabric.Response;
import org.lyh.bean.Menu;
import org.lyh.bean.ResponseResult;
import org.lyh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    //查询所有菜单信息
    @GetMapping("/findAllMenu")
    public ResponseResult responseResult(){
        List<Menu> allMenu = menuService.findAllMenu();
        return new ResponseResult(true,200,"响应成功",allMenu);
    }

    //回显菜单
    @GetMapping("/findMenuInfoById/{id}")
    public ResponseResult responseResult(@PathVariable("id") Integer id){
        List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);
        if(id==-1){

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("menuInfo",null);
            map.put("parentMenuList",subMenuListByPid);
            return new ResponseResult(true,200,"添加回显菜单成功",map);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        Menu menuById = menuService.findMenuById(id);
        map.put("menuInfo",menuById);
        map.put("parentMenuList",subMenuListByPid);
        return new ResponseResult(true,200,"修改回显菜单成功",map);
    }
}
