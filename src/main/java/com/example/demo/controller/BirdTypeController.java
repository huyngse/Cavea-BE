package com.example.demo.controller;
import com.example.demo.Entities.BirdType;
import com.example.demo.Repo.BirdTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/birdtypes")
public class BirdTypeController {

    private final BirdTypeRepository birdTypeRepository;

    @Autowired
    public BirdTypeController(BirdTypeRepository birdTypeRepository) {
        this.birdTypeRepository = birdTypeRepository;
    }

    @GetMapping
    public List<BirdType> getAllBirdTypes() {
        return birdTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BirdType> getBirdTypeById(@PathVariable("id") int id) {
        return birdTypeRepository.findById(id);
    }

    @PostMapping
    public BirdType createBirdType(@RequestBody BirdType birdType) {
        return birdTypeRepository.save(birdType);
    }

    @PutMapping("/{id}")
    public BirdType updateBirdType(@PathVariable("id") int id, @RequestBody BirdType birdType) {
        birdType.setBirdTypeId(id);
        return birdTypeRepository.save(birdType);
    }

    @DeleteMapping("/{id}")
    public void deleteBirdType(@PathVariable("id") int id) {
        birdTypeRepository.deleteById(id);
    }
}