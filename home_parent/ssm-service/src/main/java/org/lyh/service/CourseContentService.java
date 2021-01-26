package org.lyh.service;

import org.lyh.bean.Course;
import org.lyh.bean.CourseSection;

import java.util.List;

public interface CourseContentService {

    //根据课程id查询章节信息及课时信息
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    //根据课程id显示课程信息
    Course findCourseByCourseId(Integer courseId);

    //新增章节信息
    void saveSession(CourseSection courseSection);

    //更新章节信息
    void updateSession(CourseSection courseSection);

    //更新章节状态
    void updateSessionStatus(Integer id,Integer status);
}
