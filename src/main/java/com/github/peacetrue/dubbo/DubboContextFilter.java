package com.github.peacetrue.dubbo;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER;

/**
 * @author xiayx
 */
@Activate(group = {CONSUMER}, order = 10000)
public class DubboContextFilter implements Filter {

    /** 配置名 */
    public static final String FILTER_NAME = "dubboContextFilter";

    private Logger logger = LoggerFactory.getLogger(getClass());

    /** 消费者在调用时传递应用名称 */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String application = RpcContext.getContext().getUrl().getParameter("application");
        RpcContext.getContext().setAttachment("application", application);
        logger.debug("调用上下文信息[{}]", RpcContext.getContext().getAttachments());
        return invoker.invoke(invocation);
    }

    /** 在提供者应用中获取消费者应用的名称 */
    public static String getConsumerApplicationName() {
        return RpcContext.getContext().getAttachment("application");
    }
}