package com.stacja.stacja.service;

import com.stacja.stacja.entity.PlantDisease;
import com.stacja.stacja.repository.PlantDiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantDiseaseService {
    @Autowired
    private PlantDiseaseRepository plantDiseaseRepository;

    public List<PlantDisease> getAllDiseases() {
        return plantDiseaseRepository.findAll();
    }

    public Optional<PlantDisease> getDiseaseById(Long id) {
        return plantDiseaseRepository.findById(id);
    }

    public PlantDisease saveDisease(PlantDisease disease) {
        return plantDiseaseRepository.save(disease);
    }

    public void deleteDisease(Long id) {
        plantDiseaseRepository.deleteById(id);
    }
}
