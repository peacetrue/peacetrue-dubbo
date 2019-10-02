package com.github.peacetrue.dubbo.consumer;

import com.github.peacetrue.dubbo.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author xiayx
 */
@SpringBootApplication
@ImportResource("classpath:consumer.xml")
public class ConsumerApplication {

    static {
        System.setProperty("java.net.preferIPv4Stack", "true");
    }

    private static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        logger.debug("sayHello[{}]", hello);
    }

}
