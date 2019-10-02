package com.github.peacetrue.dubbo.consumer;

import com.github.peacetrue.dubbo.DemoService;
import com.github.peacetrue.dubbo.provider.ProviderApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiayx
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DubboContextFilterTest.class})
@ImportResource("classpath:consumer.xml")
public class DubboContextFilterTest {

//    static {
//        ProviderApplication.main(new String[]{});
//    }

    public static Logger logger = LoggerFactory.getLogger(DubboContextFilterTest.class);

    @Autowired
    private DemoService demoService;

    //NOTE: run ProviderApplication first
    @Test
    public void invoke() {
        logger.info("consumer starting");
        String hello = demoService.sayHello("hello");
        logger.debug("consumer return [{}]", hello);
        Assert.assertEquals("consumer-of-helloworld-app:hello", hello);
        if (ProviderApplication.context != null) {
            ProviderApplication.context.stop();
        }
    }
}
