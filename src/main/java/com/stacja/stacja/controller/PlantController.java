package com.stacja.stacja.controller;

import com.stacja.stacja.entity.Plant;
import com.stacja.stacja.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plants")
@CrossOrigin(origins = "*")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public Optional<Plant> getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    @PostMapping("/create")
    public Plant createPlant(@RequestBody Plant plant) {
        return plantService.savePlant(plant);
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }

    @GetMapping("/healthy")
    public ResponseEntity<List<Plant>> getHealthyPlants() {
        List<Plant> plants = plantService.getHealthyPlants();
        return ResponseEntity.ok(plants);
    }

    @GetMapping("/sick")
    public ResponseEntity<List<Plant>> getSickPlants() {
        List<Plant> plants = plantService.getSickPlants();
        return ResponseEntity.ok(plants);
    }
}
