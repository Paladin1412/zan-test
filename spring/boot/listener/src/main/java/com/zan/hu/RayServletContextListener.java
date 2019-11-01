package com.zan.hu;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-15 16:23
 * @Description todo
 **/
//@WebListener
public class RayServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        String appKey = sce.getServletContext().getInitParameter("appkey");
        System.out.println(appKey);

    }

    /**
     * * Notification that the servlet context is about to be shut down. All
     * servlets and filters have been destroy()ed before any
     * ServletContextListeners are notified of context destruction.
     * The default implementation is a NO-OP.
     *
     * @param sce Information about the ServletContext that was destroyed
     */
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
