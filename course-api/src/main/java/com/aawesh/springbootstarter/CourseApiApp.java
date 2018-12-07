package com.aawesh.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//this is where we are gonna bootstrap a Spring Boot application
//Remember: springboot creates a standalone app. So don't need a servlet container to run the app
//We can start this just like any other main normal java class 
// We have a main method

/**
 * 
 * @author aawesh
 *	It would require a lot of work to start a servlet container and host that application
 * in that servlet container
 * Here is the way to do that. We have an annotation for that. Annotate the main class
 */

@SpringBootApplication
@EnableSwagger2
public class CourseApiApp {

	/**
	 * 
	 * @param args
	 * Springboot has a really nice utility that helps us do that in an easy way
	 * Call a static class
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//call a static class and pass the name of the class that is CourseApiApp in this case
		//At this point, SpringBoot applicaiton is ready but it doesn't do anything right now
		SpringApplication.run(CourseApiApp.class,args);
	}
	
	@Bean
   public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.aawesh.springbootstarter")).build();
   }

}
