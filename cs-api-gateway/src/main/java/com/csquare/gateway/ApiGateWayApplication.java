package com.csquare.gateway;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.csquare.gateway.config.AppInitializer;


@SpringBootApplication
public class ApiGateWayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplicationBuilder application = new SpringApplicationBuilder();
        application.logStartupInfo(false);
        application.bannerMode(Banner.Mode.OFF);
        application.sources(ApiGateWayApplication.class, AppInitializer.class);
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        application.logStartupInfo(false);
        application.bannerMode(Banner.Mode.OFF);
        application.sources(ApiGateWayApplication.class, AppInitializer.class);

        System.out.println("Completing TestApplication.configure");
        return application;
    }
}
