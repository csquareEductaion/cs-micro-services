package com.csquare.student;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.csquare.student.config.AppInitializer;



@SpringBootApplication
public class CSquareApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        // SpringApplication.run(CodeXApplication.class, args);

        SpringApplicationBuilder application = new SpringApplicationBuilder();
        application.logStartupInfo(false);
        application.bannerMode(Banner.Mode.OFF);
        application.sources(CSquareApplication.class, AppInitializer.class);
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        // return application.sources(CodeXApplication.class);

        application.logStartupInfo(false);
        application.bannerMode(Banner.Mode.OFF);
        application.sources(CSquareApplication.class, AppInitializer.class);

        System.out.println("Completing TestApplication.configure");
        return application;
    }
}
