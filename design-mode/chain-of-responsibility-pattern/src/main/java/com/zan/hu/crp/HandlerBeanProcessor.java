package com.zan.hu.crp;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/04/26 14/13
 */
public class HandlerBeanProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext context;

    // 该方法会在一个bean初始化完成后调用，这里主要是在Pipeline初始化完成之后获取所有实现了
    // Handler接口的bean，然后通过调用Pipeline.addLast()方法将其添加到pipeline中
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof DefaultPipeline) {
            DefaultPipeline pipeline = (DefaultPipeline)bean;
            Map<String, Handler> handlerMap = context.getBeansOfType(Handler.class);
            handlerMap.forEach((name, handler) -> pipeline.addLast(handler));
        }

        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }
}
