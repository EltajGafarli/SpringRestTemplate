package com.example.tryfeingclient.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Feing Client",
                description = "try and learn feing client"
        )
)
public class OpenApiConfig {
}
