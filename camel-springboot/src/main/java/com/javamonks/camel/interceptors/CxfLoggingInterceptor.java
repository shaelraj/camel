package com.javamonks.camel.interceptors;

import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.slf4j.Slf4jVerboseEventSender;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.springframework.stereotype.Service;

@Service("cxfLoggingInterceptor")
public class CxfLoggingInterceptor extends LoggingInInterceptor{

	/**
     * Constructor ECSLoggingInInterceptor.
     */
    public CxfLoggingInterceptor() {
        super(new Slf4jVerboseEventSender());
    }

    /**
     * Handles writing the message to log file. Request content will be logged
     * only if its enabled
     * 
     * @param message message object
     * @throws Fault message
     */
    @Override
    public void handleMessage(Message message) throws Fault {
            super.handleMessage(message);
    }
}
