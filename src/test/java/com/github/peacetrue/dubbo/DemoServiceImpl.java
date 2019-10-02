package com.github.peacetrue.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceImpl implements DemoService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String sayHello(String name) {
        logger.info("consumer app [{}]", DubboContextFilter.getConsumerApplicationName());
        return DubboContextFilter.getConsumerApplicationName() + ":" + name;
    }
}