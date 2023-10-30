package com.example.demo.controller;

import com.example.demo.Entities.CageSpokes;
import com.example.demo.Entities.SpokeJunction;
import com.example.demo.Repo.BirdTypeRepository;
import com.example.demo.Repo.CageSpokesRepository;
import com.example.demo.Repo.SpokeJunctionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/cage-spokes")
public class CageSpokesController {
    private final BirdTypeRepository birdTypeRepository;
    private final CageSpokesRepository cageSpokesRepository;
    private final SpokeJunctionRepository spokeJunctionRepository;

    public CageSpokesController(
            BirdTypeRepository birdTypeRepository,
            CageSpokesRepository cageSpokesRepository,
            SpokeJunctionRepository spokeJunctionRepository) {
        this.birdTypeRepository = birdTypeRepository;
        this.cageSpokesRepository = cageSpokesRepository;
        this.spokeJunctionRepository = spokeJunctionRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getCageSpokesByBirdType(@RequestParam("birdTypeId") int birdTypeId) {
        List<Map<String, Object>> result = new ArrayList<>();

        List<Integer> spokeIds = spokeJunctionRepository.findSpokeIdsByBirdTypeId(birdTypeId);
        List<CageSpokes> cageSpokes = cageSpokesRepository.findAllById(spokeIds);

        for (CageSpokes cageSpoke : cageSpokes) {
            Map<String, Object> spokeInfo = new HashMap<>();
            spokeInfo.put("spokeId", cageSpoke.getSpokesId());
            spokeInfo.put("spokes", cageSpoke.getSpokes());

            SpokeJunction spokeJunction = spokeJunctionRepository.findBySpokeIdAndBirdTypeId(cageSpoke.getSpokesId(), birdTypeId);
            spokeInfo.put("price", spokeJunction.getPrice());

            result.add(spokeInfo);
        }

        return result;
    }
}