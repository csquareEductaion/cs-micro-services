package com.csquare.ums.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


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
        // ctx.register(WebAppConfig.class);
        // ctx.register(DataBaseConfig.class);
        ctx.setServletContext(servletContext);
        ContextProvider.setApplicationContext(ctx);

        // servletContext.addListener(new ContextListener());
        // servletContext.addListener(new ContextDestroyedListener());

        ServletRegistration.Dynamic dynamic0 = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(ctx));
        String container = System.getProperty("CONTAINER");
        if ("SELF".equals(container)) {
            dynamic0.addMapping("/CSquare-UMS/*");
        } else {
            dynamic0.addMapping("/");
        }
        dynamic0.setLoadOnStartup(1);

        // ------------------------------------------------------------------------------------------
        // ServletRegistration.Dynamic dynamic1 = servletContext.addServlet("OAuthLoginServlet", new OAuthLoginServlet());
        // dynamic1.addMapping("/sml/*");
        // dynamic1.setLoadOnStartup(1);

        // ------------------------------------------------------------------------------------------
        // addFilter(servletContext, SecureHeaderFilter.class, "SecureHeaderFilter", "/*");
    }

}