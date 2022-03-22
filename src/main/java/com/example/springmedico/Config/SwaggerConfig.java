package com.example.springmedico.Config;


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

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean    //retorna um tipo docket foi importado para a aplicação
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springmedico.Controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo= new ApiInfo(
                "DADOS ESCOLARES",
                "API REST DE CADASTRO DE ALUNOS",
                "1,0",
                "terms of service",
                new Contact("Marcos carvalho","https://github.com/marcoscarvalho99",
                        "marcoscarvalho436@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html", new ArrayList<VendorExtension>()

        );
        return  apiInfo;
    }
}