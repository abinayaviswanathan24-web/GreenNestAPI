package com.example.greennestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.greennestapi.entity.Plant;
import com.example.greennestapi.repository.PlantRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = {
	    "http://localhost:5173",
	    "https://abinayaviswanathan24-web.github.io"
	})
@RestController
@RequestMapping("/products")
public class PlantController {

    private final PlantRepository plantRepository;

    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @PostMapping
    public Plant addPlant(@RequestBody Plant plant) {
        return plantRepository.save(plant);
    }
    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Plant updatePlant(
            @PathVariable Long id,
            @RequestBody Plant updatedPlant) {

        Plant existingPlant = plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        existingPlant.setName(updatedPlant.getName());
        existingPlant.setCategory(updatedPlant.getCategory());
        existingPlant.setPrice(updatedPlant.getPrice());
        existingPlant.setImage(updatedPlant.getImage());
        existingPlant.setDescription(updatedPlant.getDescription());
        existingPlant.setOffer(updatedPlant.getOffer());

        return plantRepository.save(existingPlant);
    }
}