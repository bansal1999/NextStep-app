package com.shikhar.NextStep.posts_service.config;

import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modalMapper() {
        return new ModelMapper();
    }
}
