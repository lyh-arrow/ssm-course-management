import org.junit.Test;
import org.junit.runner.RunWith;
import org.lyh.bean.*;
import org.lyh.service.CourseContentService;
import org.lyh.service.CourseService;
import org.lyh.service.PromotionAdService;
import org.lyh.service.UserService;
import org.lyh.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class ServiceTest {

    @Autowired
    CourseService courseService;

    @Autowired
    CourseContentService courseContentService;

    @Autowired
    PromotionAdService promotionAdService;

    @Autowired
    UserService userService;


    @Test
    public void test() throws Exception {
        ResponseResult userPermissions = userService.getUserPermissions(100030012);


    }
}
