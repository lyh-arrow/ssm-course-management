package org.lyh.controller;

import org.lyh.bean.ResourceCategory;
import org.lyh.bean.ResponseResult;
import org.lyh.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    ResourceCategoryService resourceCategoryService;

    // 资源分类信息查询
    @GetMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(true,200,"响应成功",allResourceCategory);
    }

    //添加or更新资源分类
    @PostMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory){
        if(resourceCategory.getId()==null){
            resourceCategoryService.saveResourceCategory(resourceCategory);
            return new ResponseResult(true,200,"添加成功",null);
        }
        resourceCategoryService.updateResourceCategory(resourceCategory);
        return new ResponseResult(true,200,"更新成功",null);
    }

    //删除资源
    @GetMapping("/deleteResourceCategory/{id}")
    public ResponseResult deleteResourceCategory(@PathVariable("id") Integer id){
        resourceCategoryService.deleteResourceCategory(id);
        return new ResponseResult(true,200,"删除成功",null);
    }
}
