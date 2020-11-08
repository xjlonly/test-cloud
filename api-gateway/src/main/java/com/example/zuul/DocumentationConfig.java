package com.example.zuul;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> list = new ArrayList<>();
        list.add(swaggerResource("eureka-testclient","/eureka-testclient/v2/api-docs","v2"));
        list.add(swaggerResource("eureka-consumer", "/eureka-consumer/v2/api-docs","v2"));
        return list;
    }

    private SwaggerResource swaggerResource(String name, String location, String version){
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
