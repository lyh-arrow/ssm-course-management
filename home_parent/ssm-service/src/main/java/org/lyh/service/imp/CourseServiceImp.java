package org.lyh.service.imp;

import org.lyh.bean.Course;
import org.lyh.bean.CourseVO;
import org.lyh.bean.Teacher;
import org.lyh.mapper.CourseMapper;
import org.lyh.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImp  implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> findAllCourse(CourseVO courseVO) {
        return courseMapper.findAllCourse(courseVO);
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) {
        //封装course类
        Course course=new Course();
        BeanUtils.copyProperties(courseVO,course);
        LocalDateTime now = LocalDateTime.now();
        course.setCreateTime(now);
        course.setUpdateTime(now);
        System.out.println(course);
        courseMapper.saveCourse(course);

        int courseId = course.getId();

        //封装teacher类
        Teacher teacher=new Teacher();
        BeanUtils.copyProperties(courseVO,course);
        teacher.setCourseId(courseId);
        teacher.setCreateTime(now);
        teacher.setUpdateTime(now);
        courseMapper.saveTeacher(teacher);

    }

    @Override
    public CourseVO findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {
        Course course=new Course();
        BeanUtils.copyProperties(courseVO,course);
        LocalDateTime now = LocalDateTime.now();
        course.setUpdateTime(now);
        courseMapper.updateCourse(course);

        Teacher teacher=new Teacher();
        BeanUtils.copyProperties(courseVO,teacher);
        teacher.setUpdateTime(now);
        teacher.setCourseId(course.getId());
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(int courseId,int status) {
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.updateCourseStatus(course);
    }


}
