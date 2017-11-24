package com.csquare.ums;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.csquare.ums.config.AppInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class CodeXApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        System.setProperty("CONTAINER", "SELF");
        SpringApplicationBuilder application = new SpringApplicationBuilder();
        application.logStartupInfo(false);
        application.bannerMode(Banner.Mode.OFF);
        application.sources(CodeXApplication.class, AppInitializer.class);

        application.run(args);

    }

    /**
     * Server hook. will be used when deployed as war
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        System.setProperty("CONTAINER", "SERVER");
        application.logStartupInfo(false);
        application.bannerMode(Banner.Mode.OFF);
        application.sources(CodeXApplication.class, AppInitializer.class);

        return application;
    }
}
