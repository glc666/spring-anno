package com.ayuantalking.cap5;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowConditional implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1.获取到IOC使用的beanfatory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        // 3.获取当前系统环境
        Environment environment = context.getEnvironment();

        // 4.获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String osName = environment.getProperty("os.name");
        System.out.println(osName);
        if(osName.contains("Windows")){
            return true;
        }

        return false;
    }
}
