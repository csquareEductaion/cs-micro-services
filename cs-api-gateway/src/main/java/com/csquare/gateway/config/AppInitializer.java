package com.csquare.gateway.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.csquare.gateway.servlet.ApiGateWayServlet;
import com.csquare.gateway.util.StringUtil;
import com.csquare.gateway.util.SystemUtil;


/**
 * Custom class for AppInitializer
 *
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @author CodeX
 */

public class AppInitializer implements ServletContextInitializer {

    /**
     * @param servletContext - the ServletContext
     * @throws ServletException - the ServletException
     */
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setServletContext(servletContext);

        addServlet(servletContext, ctx, "/cs-api-gateway/*");
    }

    private void addServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext ctx, String urlPattern) {

        ServletRegistration.Dynamic dynamic0 = servletContext.addServlet("ApiGateWayServlet", new ApiGateWayServlet(ctx));
        String container = SystemUtil.getProperty("CONTAINER");
        if (StringUtil.equals("SELF", container)) {
            dynamic0.addMapping(urlPattern);
        } else {
            dynamic0.addMapping("/");
        }
        dynamic0.setLoadOnStartup(1);
    }

}