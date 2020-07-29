package cn.itcast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("cn.itcast.mapper")
public class MySpringBootApplication {


    public static void main(String[] args) {
        //启动springboot
        SpringApplication.run(MySpringBootApplication.class);
    }
}
