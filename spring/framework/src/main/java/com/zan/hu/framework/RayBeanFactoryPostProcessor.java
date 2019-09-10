package com.zan.hu.framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 10:14
 * @Description todo
 **/
public class RayBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryPostProcessor");
//        BeanDefinition beanDefinition =
//                beanFactory.getBeanDefinition("user");
//        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}
