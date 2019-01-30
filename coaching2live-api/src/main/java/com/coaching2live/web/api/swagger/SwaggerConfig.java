package com.coaching2live.web.api.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SwaggerConfig.class, args); 
	}

	@Bean
	public Docket petApi() {

	    return new Docket(DocumentationType.SWAGGER_2)
	        .groupName("coaching2live-api")
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("com.coaching2live.web.controller.rest"))
	            .paths(PathSelectors.any())
	        .build()
	        .apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
						.title("COACHING2LIVE API")
						.description("Documentação da API de acesso ao endpoints do coaching2live.")
						.version("1.0")
						.build();
	}
}
