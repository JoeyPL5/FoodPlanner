package com.foodplanner.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCaching
public class PlannerApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PlannerApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(PlannerApplication.class, args);
	}

}
