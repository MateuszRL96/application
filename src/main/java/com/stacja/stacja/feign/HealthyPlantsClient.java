package com.stacja.stacja.feign;


import com.stacja.stacja.entity.Plant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "healthy-plants-service", url = "localhost:8091")
public interface HealthyPlantsClient {

    @GetMapping("/plants/healthy")
    ResponseEntity<List<Plant>> getHealthyPlants();
}
