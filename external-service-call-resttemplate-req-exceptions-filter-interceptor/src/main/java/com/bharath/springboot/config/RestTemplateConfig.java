package com.bharath.springboot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.bharath.springboot.errorhandeling.CustomResponseErrorHandler;

@Configuration
public class RestTemplateConfig {
	
	
	static final int TIMEOUT = 5000;

    @Bean
    RestTemplate restTemplateWithConnectReadTimeout() {
    
        return new RestTemplateBuilder()
                .errorHandler(new CustomResponseErrorHandler())
                .setConnectTimeout(5000)
                .setReadTimeout(5000)
                .build();
       
    }

}
