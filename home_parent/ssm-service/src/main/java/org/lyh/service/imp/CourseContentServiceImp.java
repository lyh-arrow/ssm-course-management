package org.lyh.service.imp;

import org.lyh.bean.Course;
import org.lyh.bean.CourseSection;
import org.lyh.mapper.CourseContentMapper;
import org.lyh.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseContentServiceImp implements CourseContentService {

    @Autowired
    CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    @Override
    public Course findCourseByCourseId(Integer courseId) {
        return courseContentMapper.findCourseByCourseId(courseId);
    }

    @Override
    public void saveSession(CourseSection courseSection) {
        courseSection.setCreateTime(LocalDateTime.now());
        courseSection.setUpdateTime(LocalDateTime.now());
        courseContentMapper.saveSession(courseSection);
    }

    @Override
    public void updateSession(CourseSection courseSection) {
        courseSection.setUpdateTime(LocalDateTime.now());
        courseContentMapper.updateSession(courseSection);
    }

    @Override
    public void updateSessionStatus(Integer id, Integer status) {
        CourseSection courseSection=new CourseSection();
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseSection.setUpdateTime(LocalDateTime.now());
        courseContentMapper.updateSessionStatus(courseSection);
    }
}
