package org.lyh.controller;

import com.github.pagehelper.PageInfo;
import org.lyh.bean.PromotionAd;
import org.lyh.bean.PromotionAdVO;
import org.lyh.bean.ResponseResult;
import org.lyh.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/promotionAd")
public class PromotionAdController {

    @Autowired
    PromotionAdService promotionAdService;

    // 广告分页查询
    @GetMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO promotionAdVO){
        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVO);
        return new ResponseResult(true,200,"响应成功",pageInfo);
    }

    //图片上传p
    @PostMapping("/promotionAdUpload")
    public ResponseResult promotionAdUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //判断上传的文件是否为空
        if(file.isEmpty()){
            throw new RuntimeException();
        }

        //获取服务器tomcat的路径
        // D:\Development\apache-tomcat-8.5.60\webapps\ssm-web\
        String realPath = request.getServletContext().getRealPath("/");
        // 获取webapps路径
        //D:\Development\apache-tomcat-8.5.60\webapps
        String webapp = realPath.substring(0, realPath.indexOf("ssm-web"));

        //获取上传的文件名
        // 例如：1.jpg
        String originalFilename = file.getOriginalFilename();

        //修改文件名
        // System.currentTimeMillis().jpg
        String newFileName =  System.currentTimeMillis()+ originalFilename.substring(originalFilename.lastIndexOf("."));

        //指定要上传的文件夹路径
        // D:\Development\apache-tomcat-8.5.60\webapps\\upload\\
        String uploadFile=webapp+"upload\\";
        File filePath =new File(uploadFile,newFileName);

        //判断文件夹是否存在
        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
        }
        //上传文件
        file.transferTo(filePath);

        Map<String, String> map=new HashMap<>();
        map.put("fileName",newFileName);
        String url=request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort()+"/upload/"+newFileName;
        map.put("filePath",url);
        return new ResponseResult(true,200,"文件上传成功",map);
    }

    //更新广告状态
    @GetMapping("/updatePromotionAdStatus/{id}/{status}")
    public ResponseResult responseResult(@PathVariable("id") Integer id,@PathVariable("status") Integer status ){
        promotionAdService.updatePromotionAdStatus(id,status);
        return new ResponseResult(true,200,"更新状态成功",status);
    }
}
