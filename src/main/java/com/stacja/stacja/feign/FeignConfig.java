package com.stacja.stacja.feign;

import feign.Feign;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
    @Bean
    public FeignContext feignContext() {
        return new FeignContext();
    }
    @Bean
    public FeignClientProperties feignClientProperties() {
        return new FeignClientProperties();
    }
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Bean
    public HealthyPlantsClient healthyPlantsClient() {
        return feignBuilder().target(HealthyPlantsClient.class, "http://localhost:8091/healthy");
    }

    @Bean
    public SickPlantsClient illnessPlantsClient() {
        return feignBuilder().target(SickPlantsClient.class, "http://localhost:8090/illness");
    }
}


