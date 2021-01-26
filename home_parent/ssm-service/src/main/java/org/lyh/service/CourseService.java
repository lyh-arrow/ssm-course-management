package org.lyh.service;

import org.lyh.bean.Course;
import org.lyh.bean.CourseVO;

import java.util.List;

public interface CourseService {

    //多条件查询课程
    List<Course> findAllCourse(CourseVO courseVO);

    //保存课程教师信息
    void saveCourseOrTeacher(CourseVO courseVO);

    //根据课程id显示课程和教师信息
    CourseVO findCourseById(Integer id);

    //更新课程教师信息
    void updateCourseOrTeacher(CourseVO courseVO);

    //课程状态管理
    void updateCourseStatus(int courseId,int status);
}
