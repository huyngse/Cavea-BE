package com.example.demo.controller;

import com.example.demo.Entities.CageShape;
import com.example.demo.Entities.ShapeJunction;
import com.example.demo.Repo.BirdTypeRepository;
import com.example.demo.Repo.CageShapeRepository;
import com.example.demo.Repo.ShapeJunctionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/cage-shapes")
public class CageShapeController {
    private final BirdTypeRepository birdTypeRepository;
    private final CageShapeRepository cageShapeRepository;
    private final ShapeJunctionRepository shapeJunctionRepository;

    public CageShapeController(
            BirdTypeRepository birdTypeRepository,
            CageShapeRepository cageShapeRepository,
            ShapeJunctionRepository shapeJunctionRepository) {
        this.birdTypeRepository = birdTypeRepository;
        this.cageShapeRepository = cageShapeRepository;
        this.shapeJunctionRepository = shapeJunctionRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getCageShapesByBirdType(@RequestParam("birdTypeId") int birdTypeId) {
        List<Map<String, Object>> result = new ArrayList<>();

        List<Integer> shapeIds = shapeJunctionRepository.findShapeIdsByBirdTypeId(birdTypeId);
        List<CageShape> cageShapes = cageShapeRepository.findAllById(shapeIds);

        for (CageShape cageShape : cageShapes) {
            Map<String, Object> shapeInfo = new HashMap<>();
            shapeInfo.put("shapeId", cageShape.getShapeId());
            shapeInfo.put("shape", cageShape.getShape());
            shapeInfo.put("imageUrl", cageShape.getImageUrl());
            ShapeJunction shapeJunction = shapeJunctionRepository.findByShapeIdAndBirdTypeId(cageShape.getShapeId(), birdTypeId);
            shapeInfo.put("price", shapeJunction.getPrice());

            result.add(shapeInfo);
        }

        return result;
    }
}