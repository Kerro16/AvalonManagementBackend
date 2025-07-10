package com.kerro.AvalonManagementBackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMapper {

    @Bean
    public ModelMapper modelmapper(){
        return new ModelMapper();
    }

} 