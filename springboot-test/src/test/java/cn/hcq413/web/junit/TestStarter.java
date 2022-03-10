package cn.hcq413.web.junit;

import cn.hcq413.starter.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStarter {

    @Autowired
    //测试容器是有helloservice实例
    HelloService helloService;

    @Test
    public void test1() {
        String hello = helloService.hello();
        System.err.println(hello);
    }
}
