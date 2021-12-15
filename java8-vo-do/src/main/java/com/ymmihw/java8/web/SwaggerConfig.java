package com.ymmihw.java8.web;

import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket createRestApi() {

    Parameter parameter =
        new ParameterBuilder()
            .name("Authorization")
            .description("token令牌")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build();

    List<Parameter> parameters = new ArrayList<>();
    parameters.add(parameter);

    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build()
        .globalOperationParameters(parameters);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Doc").version("1.0").build();
  }
}
