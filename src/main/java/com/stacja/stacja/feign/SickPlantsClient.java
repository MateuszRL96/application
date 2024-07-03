package com.stacja.stacja.feign;


import com.stacja.stacja.entity.Plant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "sick-plants-service", url = "localhost:8091")
public interface SickPlantsClient {

    @GetMapping("/plants/sick")
    ResponseEntity<List<Plant>> getSickPlants();
}
