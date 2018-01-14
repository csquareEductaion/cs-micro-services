package com.csquare.ref.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Custom class for WebAppConfig
 *
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @author CodeX
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.csquare.ref.controller", "com.csquare.ref.service", "com.csquare.ref.dao" })
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}