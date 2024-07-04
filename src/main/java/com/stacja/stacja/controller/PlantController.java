package com.stacja.stacja.controller;

import com.stacja.stacja.entity.Plant;
import com.stacja.stacja.feign.HealthyPlantsClient;
import com.stacja.stacja.feign.SickPlantsClient;
import com.stacja.stacja.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin("*")
public class PlantController {

    private final HealthyPlantsClient healthyPlantsClient;
    private final SickPlantsClient illnessPlantsClient;

    public PlantController(HealthyPlantsClient healthyPlantsClient, SickPlantsClient illnessPlantsClient) {
        this.healthyPlantsClient = healthyPlantsClient;
        this.illnessPlantsClient = illnessPlantsClient;
    }

    @PostMapping
    public ResponseEntity<String> addPlant(@RequestBody Plant plant) {
        if ("healthy".equalsIgnoreCase(String.valueOf(plant.getStatus()))) {
            return healthyPlantsClient.addHealthyPlant(plant);
        } else if ("illness".equalsIgnoreCase(String.valueOf(plant.getStatus()))) {
            return illnessPlantsClient.addIllnessPlant(plant);
        }
        return ResponseEntity.badRequest().body("Unknown status");
    }
}

