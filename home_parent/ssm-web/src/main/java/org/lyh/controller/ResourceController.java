package org.lyh.controller;


import org.lyh.bean.Resource;
import org.lyh.bean.ResourceVo;
import org.lyh.bean.ResponseResult;
import org.lyh.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceMapper resourceMapper;

    // 资源信息分页&条件查询
    @PostMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVo resourceVo){
        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);
        return new ResponseResult(true,200,"响应成功",allResource);
    }

}
