package com.backend.laundarybackend.config;

import com.enzoic.client.Enzoic;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Enzoic enzoicBean(){ return new Enzoic(ApiConfig.ENZOIC_API_KEY,ApiConfig.ENZOIC_API_SECRET);}

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
