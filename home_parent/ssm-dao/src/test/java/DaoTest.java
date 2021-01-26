import org.junit.Test;
import org.junit.runner.RunWith;
import org.lyh.bean.Course;
import org.lyh.bean.CourseVO;
import org.lyh.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class DaoTest {


    @Autowired
    CourseMapper courseMapper;

    @Test
    public void test(){
        CourseVO courseVO=new CourseVO();
        courseVO.setCourseName("Vue.js 3.0 核心源码解析");
        List<Course> allCourse = courseMapper.findAllCourse(courseVO);
        allCourse.forEach(System.out::println);
    }
}
