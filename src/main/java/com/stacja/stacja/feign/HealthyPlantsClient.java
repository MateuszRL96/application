package com.stacja.stacja.feign;


import com.stacja.stacja.entity.Plant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "healthyPlantsService", url = "http://localhost:8091/api")
public interface HealthyPlantsClient {

    @GetMapping("/plants/healthy")
    ResponseEntity<List<Plant>> getHealthyPlants();

    @PostMapping("/plants")
    ResponseEntity<String> addHealthyPlant(Plant plant);
}
