package cn.itcast.test;

import cn.itcast.MySpringBootApplication;
import cn.itcast.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//创建容器
//@RunWith(SpringJUnit4ClassRunner)
@RunWith(SpringRunner.class)
//指定配置文件
//@ContextConfiguration(classes = MySpringBootApplication.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class MyBatisTest {
    @Autowired
    private UserMapper um;

    @Test
    public  void fun1() {
        System.out.println(um.findById(1L));
    }



}
