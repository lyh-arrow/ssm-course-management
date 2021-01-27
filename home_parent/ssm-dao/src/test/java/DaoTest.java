import org.junit.Test;
import org.junit.runner.RunWith;
import org.lyh.bean.Course;
import org.lyh.bean.CourseVO;
import org.lyh.bean.Resource;
import org.lyh.mapper.CourseMapper;
import org.lyh.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class DaoTest {


    @Autowired
    CourseMapper courseMapper;

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void test(){

    }
}
