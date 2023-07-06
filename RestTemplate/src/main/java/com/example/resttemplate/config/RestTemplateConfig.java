package com.example.resttemplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfig {

    @Value("${rest.template.rootUrl}")
    private String rootUrl;

    @Bean(name = "80821")
    public RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer){
        System.out.println("80821 port run");
        RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());
        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory(rootUrl);
        return builder.uriTemplateHandler(defaultUriBuilderFactory);
    }

    @Bean(name = "80822")
    public RestTemplateBuilder restTemplateBuilder1(RestTemplateBuilderConfigurer configurer){
        System.out.println("80822 port run");
        return new RestTemplateBuilder();
    }
}
