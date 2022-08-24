package cn.itcast.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    //创建RestTemplate 并注入Spring容器
    //注册RestTemplate对象到容器中管理，提供给java实现一个ajax（http请求）效果的远程调用程序
    //因为@Bean注入的注册必须在配置类里边，而SpringBootApplication本身里面就包含了配置类
    //因此可以放在这里进行注册
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

