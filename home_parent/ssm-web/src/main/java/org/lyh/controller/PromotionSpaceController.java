package org.lyh.controller;


import org.lyh.bean.PromotionSpace;
import org.lyh.bean.ResponseResult;
import org.lyh.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    PromotionSpaceService promotionSpaceService;

    // 查询所有广告位
    @GetMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> allPromotionSpace = promotionSpaceService.findAllPromotionSpace();
        return new ResponseResult(true,200,"响应成功",allPromotionSpace);
    }
    
    //添加or更新广告位
    @PostMapping("saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        if(promotionSpace.getId()==null){
            promotionSpaceService.savePromotionSpace(promotionSpace);
            return new ResponseResult(true,200,"添加广告位成功",null);
        }
        promotionSpaceService.updatePromotionSpace(promotionSpace);
        return new ResponseResult(true,200,"更新广告位成功",promotionSpace);
    }

    //根据id查询广告位
    @GetMapping("/findPromotionSpaceById/{id}")
    public ResponseResult findPromotionSpaceById(@PathVariable("id") Integer id){
        PromotionSpace promotionSpaceById = promotionSpaceService.findPromotionSpaceById(id);
        return new ResponseResult(true,200,"响应成功",promotionSpaceById);
    }
}
