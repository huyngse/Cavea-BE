package com.example.demo.controller;

import com.example.demo.Entities.CageMaterial;
import com.example.demo.Entities.MaterialJunction;
import com.example.demo.Repo.BirdTypeRepository;
import com.example.demo.Repo.CageMaterialRepository;
import com.example.demo.Repo.MaterialJunctionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/cage-materials")
public class CageMaterialController {
    private final BirdTypeRepository birdTypeRepository;
    private final CageMaterialRepository cageMaterialRepository;
    private final MaterialJunctionRepository materialJunctionRepository;

    public CageMaterialController(
            BirdTypeRepository birdTypeRepository,
            CageMaterialRepository cageMaterialRepository,
            MaterialJunctionRepository materialJunctionRepository) {
        this.birdTypeRepository = birdTypeRepository;
        this.cageMaterialRepository = cageMaterialRepository;
        this.materialJunctionRepository = materialJunctionRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getCageMaterialsByBirdType(@RequestParam("birdTypeId") int birdTypeId) {
        List<Map<String, Object>> result = new ArrayList<>();

        List<Integer> materialIds = materialJunctionRepository.findMaterialIdsByBirdTypeId(birdTypeId);
        List<CageMaterial> cageMaterials = cageMaterialRepository.findAllById(materialIds);

        for (CageMaterial cageMaterial : cageMaterials) {
            Map<String, Object> materialInfo = new HashMap<>();
            materialInfo.put("materialId", cageMaterial.getMaterialId());
            materialInfo.put("imageUrl", cageMaterial.getImageUrl());
            materialInfo.put("material", cageMaterial.getMaterial());
            MaterialJunction materialJunction = materialJunctionRepository.findByMaterialIdAndBirdTypeId(cageMaterial.getMaterialId(), birdTypeId);
            materialInfo.put("price", materialJunction.getPrice());

            result.add(materialInfo);
        }

        return result;
    }
}