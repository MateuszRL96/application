package com.stacja.stacja.controller;

import com.stacja.stacja.entity.PlantDisease;
import com.stacja.stacja.service.PlantDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diseases")
@CrossOrigin(origins = "http://localhost:51583")
public class PlantDiseaseController {
    @Autowired
    private PlantDiseaseService plantDiseaseService;

    @GetMapping
    public List<PlantDisease> getAllDiseases() {
        return plantDiseaseService.getAllDiseases();
    }

    @GetMapping("/{id}")
    public Optional<PlantDisease> getDiseaseById(@PathVariable Long id) {
        return plantDiseaseService.getDiseaseById(id);
    }

    @PostMapping
    public PlantDisease createDisease(@RequestBody PlantDisease disease) {
        return plantDiseaseService.saveDisease(disease);
    }

    @DeleteMapping("/{id}")
    public void deleteDisease(@PathVariable Long id) {
        plantDiseaseService.deleteDisease(id);
    }
}

