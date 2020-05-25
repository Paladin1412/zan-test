package com.zan.hu.crp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/04/26 14/48
 */
public class ApplicationService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    HttpServletRequest httpServletRequest;

    public void mockedClient() {
        Pipeline pipeline = newPipeline(httpServletRequest);
        try {
            pipeline.fireTaskReceived();
            pipeline.fireTaskFiltered();
            pipeline.fireTaskExecuted();
        } finally {
            pipeline.fireAfterCompletion();
        }
    }

    private Pipeline newPipeline(HttpServletRequest request) {
        return context.getBean(DefaultPipeline.class, request);
    }
}
