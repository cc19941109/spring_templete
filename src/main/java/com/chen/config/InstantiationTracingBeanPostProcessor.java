package com.chen.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {  
	  
    // simply return the instantiated bean as-is  
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {  
        return bean; // we could potentially return any object reference here...  
    }  
    //在创建bean后输出bean的信息  
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {  
        System.err.println("Bean '" + beanName + "' created : " + bean.toString());  
        
        return bean;  
    }  
}  
