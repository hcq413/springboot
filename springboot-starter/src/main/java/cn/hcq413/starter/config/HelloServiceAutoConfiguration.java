package cn.hcq413.starter.config;

import cn.hcq413.starter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类，功能：产生HelloService的实例，并由容器托管
 *
 * @author 黄昌其
 * @date 2022/03/08
 */

@SuppressWarnings("all")
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)///条件：当前classpath之下存在HelloService类时，自动配置生效
public class HelloServiceAutoConfiguration {


    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setName(helloProperties.getName());
        service.setMsg(helloProperties.getMsg());
        return service;
    }

}
