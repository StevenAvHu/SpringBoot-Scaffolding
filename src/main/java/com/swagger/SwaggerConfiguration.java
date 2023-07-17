package com.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties
public class SwaggerConfiguration {
    /**
     * 开关
     */
    @Value("${swagger.flag}")
    private boolean swageerFlag;

    /**
     *
     * @return Docket
     */
    @Bean
    public Docket swaggerPersonApi(){
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("version").description("版本字段不要改").modelRef(new ModelRef("String"))
                .parameterType("header").required(false).defaultValue("v.1.0.0").build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swageerFlag)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Hu-Project API")
                        .description("Documentation Demo API v1.0").build());
    }
}
