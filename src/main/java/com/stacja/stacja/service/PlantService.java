package com.stacja.stacja.service;

import com.stacja.stacja.entity.Plant;
import com.stacja.stacja.feign.HealthyPlantsClient;
import com.stacja.stacja.feign.SickPlantsClient;
import com.stacja.stacja.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    private final HealthyPlantsClient healthyPlantsClient;
    private final SickPlantsClient sickPlantsClient;
    private final PlantRepository plantRepository;

    public PlantService(HealthyPlantsClient healthyPlantsClient, SickPlantsClient sickPlantsClient, PlantRepository plantRepository) {
        this.healthyPlantsClient = healthyPlantsClient;
        this.sickPlantsClient = sickPlantsClient;
        this.plantRepository = plantRepository;
    }
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Optional<Plant> getPlantById(Long id) {
        return plantRepository.findById(id);
    }

    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }

    public List<Plant> getHealthyPlants() {
        return healthyPlantsClient.getHealthyPlants().getBody();
    }

    public List<Plant> getSickPlants() {
        return sickPlantsClient.getSickPlants().getBody();
    }
}
