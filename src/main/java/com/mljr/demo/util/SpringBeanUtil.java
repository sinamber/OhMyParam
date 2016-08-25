package com.mljr.demo.util;


import org.springframework.context.ApplicationContext;

public class SpringBeanUtil {
    private static ApplicationContext context;

    public static void setContext(ApplicationContext contextinject) {
        if (context != null) {
            return;
        }
        context = contextinject;
    }

    public static Object getBeanByName(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }

}