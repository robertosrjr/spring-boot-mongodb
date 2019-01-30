
package com.coaching2live.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.WebApplicationInitializer;

import com.coaching2live.web.api.swagger.SwaggerConfig;

@SpringBootApplication
@EnableMongoAuditing
@ComponentScan({"com.coaching2live.model",			
					"com.coaching2live.business",
					"com.coaching2live.service",
					"com.coaching2live.web"})
@EnableMongoRepositories(basePackages={"com.coaching2live.repository"})
@EnableHypermediaSupport(type={HypermediaType.HAL})
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	static Class[] apps = {Application.class, SwaggerConfig.class};

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(apps);
	}
	
	public static void main(String[] args) {

		SpringApplication.run(apps, args);
	}
}