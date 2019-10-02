package com.github.peacetrue.dubbo.provider;

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
@ImportResource("classpath:provider.xml")
public class ProviderApplication {

    static {
        System.setProperty("java.net.preferIPv4Stack", "true");
    }

    public static Logger logger = LoggerFactory.getLogger(ProviderApplication.class);
    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        logger.info("provider starting");
        context = SpringApplication.run(ProviderApplication.class, args);
        logger.debug("provider context: [{}]", context);
    }
}
