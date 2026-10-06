package com.example.greennestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.greennestapi.entity.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}