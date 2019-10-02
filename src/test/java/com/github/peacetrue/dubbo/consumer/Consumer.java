package com.github.peacetrue.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.github.peacetrue.dubbo.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiayx
 */
public class Consumer {

    static {
        System.setProperty("java.net.preferIPv4Stack", "true");
    }

    private static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        logger.debug("sayHello[{}]", hello);
        logger.debug("context[{}]", RpcContext.getContext().getAttachments());
    }
}
