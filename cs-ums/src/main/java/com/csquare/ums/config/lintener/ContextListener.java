package com.csquare.ums.config.lintener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class ContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {

        LOGGER.info("Starting ContextListener.contextInitialized");

        LOGGER.info("Finishing ContextListener.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

        LOGGER.info("Starting ContextListener.contextDestroyed");

        LOGGER.info("Finishing ContextListener.contextDestroyed");
    }
}
