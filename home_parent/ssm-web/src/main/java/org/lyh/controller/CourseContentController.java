package org.lyh.controller;

import org.lyh.bean.Course;
import org.lyh.bean.CourseSection;
import org.lyh.bean.ResponseResult;
import org.lyh.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    CourseContentService courseContentService;

    //根据课程id查询章节信息及课时信息
    @GetMapping("/findSectionAndLesson/{courseId}")
    public ResponseResult findSectionAndLesson(@PathVariable("courseId") Integer courseId){
        List<CourseSection> sectionAndLessonByCourse = courseContentService.findSectionAndLessonByCourseId(courseId);
        return new ResponseResult(true,200,"响应成功",sectionAndLessonByCourse);
    }

    //根据课程id显示课程信息
    @GetMapping("/findCourseByCourseId/{courseId}")
    public ResponseResult findCourseByCourseId(@PathVariable("courseId") Integer courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        return new ResponseResult(true,200,"响应成功",course);
    }

    //新增or更新章节信息
    @PostMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        if(courseSection.getId()==null) {
            courseContentService.saveSession(courseSection);
            return new ResponseResult(true, 200, "新增章节成功", null);
        }
        courseContentService.updateSession(courseSection);
            return new ResponseResult(true, 200, "更新章节成功", courseSection);
    }

    //更新章节状态
    @GetMapping("/updateSectionStatus/{id}/{status}")
    public ResponseResult updateSectionStatus(@PathVariable("id") Integer id,@PathVariable("status") Integer status){
        courseContentService.updateSessionStatus(id,status);
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("status",status);
        return new ResponseResult(true,200,"更新章节状态成功",map);
    }
}
