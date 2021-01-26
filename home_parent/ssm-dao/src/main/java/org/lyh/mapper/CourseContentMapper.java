package org.lyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lyh.bean.Course;
import org.lyh.bean.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    //根据课程id查询章节信息及课时信息
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    //根据课程id显示课程信息
    @Select(" select id,course_name from course where id = #{courseId}")
    Course findCourseByCourseId(Integer courseId);

    //新增章节信息
    @Insert("INSERT INTO course_section(\n" +
            "            course_id,\n" +
            "            section_name,\n" +
            "            description,\n" +
            "            order_num,\n" +
            "            STATUS,\n" +
            "            create_time,\n" +
            "            update_time\n" +
            "        )VALUES(#{courseId},#{sectionName},#{description},#{orderNum},\n" +
            "        #{status},#{createTime},#{updateTime});")
    void saveSession(CourseSection courseSection);

    //更新章节信息
    void updateSession(CourseSection courseSection);

    //更新章节状态
    @Update("update course_section set status = #{status},update_time = #{updateTime} where id = #{id}")
    void updateSessionStatus(CourseSection courseSection);
}
