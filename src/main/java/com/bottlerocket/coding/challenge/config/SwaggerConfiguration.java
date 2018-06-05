package com.bottlerocket.coding.challenge.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration 
{                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.bottlerocket.coding.challenge.api"))
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                          
    }
    
    @SuppressWarnings("rawtypes")
	private ApiInfo apiInfo() 
    {
		Contact contact = new Contact("Michael Hanna", 
										"https://www.linkedin.com/in/mhannali/", 
										"engineeringatwork@icloud.com");
       		
		ApiInfo apiInfo = new ApiInfo("Bottle Rocket API", 
        								"This API enables output of various shows and its related show content", 
        								"1.0", 
        								"", 
        								contact, 
        								"", 
        								"", 
        								new ArrayList<VendorExtension>());
        	
        return apiInfo;
    }
}
