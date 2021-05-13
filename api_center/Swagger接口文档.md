# API接口文档Swagger使用指南

###  1. 引入Swagger依赖

```pom
<!-- swagger -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

### 2. 集成Swagger

```
package org.example.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())  //显示所有类
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))  //只显示添加@Api注解的类
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("开放接口API")  //粗标题
                .description("HTTP对外开放接口")   //描述
                .version("1.0.0")   //api version
                .termsOfServiceUrl("http://xxx.xxx.com")
                .license("LICENSE")   //链接名称
                .licenseUrl("http://xxx.xxx.com")   //链接地址
                .build();
    }

}
```

### 3. 常用注解

**@Api**

作用于类，表示该类为接口类

属性：

value 接口描述

tags 标签

例：@Api(value = "字典基础接口", tags = {"字典模块"})



**@ApiOperation**

作用于方法，表示对该方法操作的表述

属性：

value 请求描述

notes 备注

httpMethod 请求类型

例：@ApiOperation(value = "获取字典", notes = "根据主键获取字典", httpMethod = "GET")



**@ApiModel**

作用于传输模型类

属性：

value 模型描述

description 详细描述

例：@ApiModel(value = "字典DO", description = "字典领域对象")



**@ApiModelProperty**

作用于模型内字段用于描述字典

属性：

value 模型字段描述

example 例子

例：@ApiModelProperty(value = "字典", example = "UUID")