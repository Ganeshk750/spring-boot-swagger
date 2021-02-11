package com.ganesh.swagger.configuration;

/*
 * @created: 11/02/2021 - 5:35 PM
 * @author: Ganesh
 */

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration {

    public static final Contact DEFAULT_CONTACT = new Contact("Ganesh", "http://github.com/ganeshk750", "ganeshkr04@gmail.com");
    public static final ApiInfo DEFAULT_INFO = new ApiInfo(
            "API Documentation",
            "Test Documentation",
            "1.0", "urn:tos",
            DEFAULT_CONTACT,
            "Demo 2.0",
                    "http://github.com/ganeshk750/licenses/LICENSE-2.0");
    @Bean
    public Docket api(){
      return  new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(DEFAULT_INFO);
            //  .select()
            //  .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
            //  .build();
    }

}
