package com.csquare.lead.config;

import org.springframework.context.ApplicationContext;


/**
 * Custom class for ContextProvider
 *
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @author CodeX
 */

public class ContextProvider {

    private static ApplicationContext CONTEXT;

    /**
     * @param applicationContext - the ApplicationContext
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {

        CONTEXT = applicationContext;
    }

    /**
     * Get a Spring bean by type.
     * 
     * @param beanClass - the Class<T>
     * @return CONTEXT.getBean(beanClass);
     **/
    public static <T> T getBean(Class<T> beanClass) {

        return CONTEXT.getBean(beanClass);
    }

    /**
     * Get a Spring bean by name.
     * 
     * @param beanName - the String
     **/
    public static Object getBean(String beanName) {

        return CONTEXT.getBean(beanName);
    }
}