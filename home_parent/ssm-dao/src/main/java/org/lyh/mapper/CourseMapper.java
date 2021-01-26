package org.lyh.mapper;

import org.lyh.bean.Course;
import org.lyh.bean.CourseVO;
import org.lyh.bean.Teacher;

import java.util.List;

public interface CourseMapper {

    //多条件查询课程
    List<Course> findAllCourse(CourseVO courseVO);

    //新增课程信息
    void saveCourse(Course course);

    //新增教师信息
    void saveTeacher(Teacher teacher);

    //根据课程id显示课程和教师信息
    CourseVO findCourseById(Integer id);

    //更新课程信息
    void updateCourse(Course course);

    //更新教师信息
    void updateTeacher(Teacher teacher);

    //课程状态管理
    void updateCourseStatus(Course course);
}
