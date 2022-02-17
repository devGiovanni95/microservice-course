package com.giovanni.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //Padrao de projeto singleton que é uma instacia unica para termos a disposição um objeto RestTemplate para injetar em outros serviços

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();

    }
}
