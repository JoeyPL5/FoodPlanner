package com.foodplanner.project.Planner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PlannerApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PlannerApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(PlannerApplication.class, args);
	}

}
