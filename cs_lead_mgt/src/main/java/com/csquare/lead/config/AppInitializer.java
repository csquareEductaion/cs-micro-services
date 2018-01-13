package com.csquare.lead.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
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
        ctx.setServletContext(servletContext);
        ContextProvider.setApplicationContext(ctx);

        addListener(servletContext);
       // addFilter(servletContext, SecureHeaderFilter.class, "SecureHeaderFilter", "/*");
        addServlet(servletContext, ctx, "/csquare/*");

    }

    private void addListener(ServletContext servletContext) {

       // servletContext.addListener(new ContextListener());
    }

    private void addServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext ctx, String urlPattern) {

        ServletRegistration.Dynamic dynamic0 = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(ctx));
        dynamic0.addMapping(urlPattern);
        dynamic0.setLoadOnStartup(1);
    }

    /**
     * Method to register filter
     *
     * @param servletContext - The ServletContext
     * @param filterClass - The Class<? extends Filter>
     * @param filterName - The String
     * @param urlPattern - The String
     */
    private void addFilter(ServletContext servletContext, Class<? extends Filter> filterClass, String filterName, String urlPattern) {

        FilterRegistration.Dynamic dynamic = servletContext.addFilter(filterName, filterClass);
        dynamic.addMappingForUrlPatterns(null, false, urlPattern);
        // dynamic.setInitParameter("encoding", "UTF-8");
        // dynamic.setInitParameter("Allow-Origin", "http://localhost:8080");
        // dynamic.setInitParameter("XFRAMEOPTIONS", "SAMEORIGIN");
        // dynamic.setInitParameter("httpsEnabled", "false");
    }

}