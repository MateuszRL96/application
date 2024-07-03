package com.stacja.stacja.repository;

import com.stacja.stacja.entity.PlantDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantDiseaseRepository extends JpaRepository<PlantDisease, Long> {
}
