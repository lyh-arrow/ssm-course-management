package org.lyh.controller;

import org.lyh.bean.Course;
import org.lyh.bean.CourseVO;
import org.lyh.bean.ResponseResult;
import org.lyh.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/findAllCourse")
    public ResponseResult findAllCourse(@RequestBody CourseVO courseVO){
        List<Course> allCourse = courseService.findAllCourse(courseVO);
        return new ResponseResult(true, 200, "响应成功", allCourse);
    }

    //文件上传
    @PostMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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

    //新增or更新课程及教师信息
    @PostMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO){
        if(courseVO.getId()==null) {
            courseService.saveCourseOrTeacher(courseVO);
            return new ResponseResult(true, 200, "新增成功", null);
        }
        courseService.updateCourseOrTeacher(courseVO);
        return new ResponseResult(true,200,"更新成功",courseVO);
    }

    //根据课程id显示课程和教师信息
    @GetMapping("/findCourseById/{id}")
    public ResponseResult findCourseById(@PathVariable("id") Integer id){
        CourseVO courseVO = courseService.findCourseById(id);
        return new ResponseResult(true,200,"响应成功",courseVO);
    }

    //课程状态信息管理
    @GetMapping("/updateCourseStatus/{status}/{courseId}")
    public ResponseResult updateCourseStatus(@PathVariable("status") Integer status,@PathVariable("courseId") Integer courseId){
        courseService.updateCourseStatus(courseId,status);
        Map<String,Integer> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true,200,"响应成功",map);
    }

}
