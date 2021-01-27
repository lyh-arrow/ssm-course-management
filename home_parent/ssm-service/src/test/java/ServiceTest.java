import org.junit.Test;
import org.junit.runner.RunWith;
import org.lyh.bean.*;
import org.lyh.service.*;
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

    @Autowired
    RoleService roleService;


    @Test
    public void test() throws Exception {
        List<ResourceCategory> resourceListByRoleId = roleService.findResourceListByRoleId(1);

    }
}
