//package com.cervantes.cervantes.configs;
//
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig extends WebMvcConfigurationSupport{
//
//	
//	@Bean
//    public Docket testApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.cervantes.cervantes.controller.CervantesControllerAddCustomer"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(metaData());
//    }
//	
//	private ApiInfo metaData() {
//        return new ApiInfo(
//                "Cervantes BroadBand Service Spring Boot REST API - AddCustomer MicroService",
//                "Cervantes BroadBand Service Spring Boot REST API",
//                "1.0",
//                "Terms of service",
//                new Contact("Cervantes", "Cervantes", "Cervantes@cervantes.com"),
//                "ExpApp License Version 1.0",
//                "Cervantes",
//                Collections.emptyList()
//        );
//    }
//	
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//            registry.addResourceHandler("swagger-ui.html")
//                    .addResourceLocations("classpath:/META-INF/resources/");
//
//            registry.addResourceHandler("/webjars/**")
//                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//    }
//	
//}
