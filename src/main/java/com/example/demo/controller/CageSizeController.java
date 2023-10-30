package com.example.demo.controller;

import com.example.demo.Entities.CageSize;
import com.example.demo.Entities.SizeJunction;
import com.example.demo.Repo.BirdTypeRepository;
import com.example.demo.Repo.CageSizeRepository;
import com.example.demo.Repo.SizeJunctionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/cage-sizes")
public class CageSizeController {
    private final BirdTypeRepository birdTypeRepository;
    private final CageSizeRepository cageSizeRepository;
    private final SizeJunctionRepository sizeJunctionRepository;

    public CageSizeController(
            BirdTypeRepository birdTypeRepository,
            CageSizeRepository cageSizeRepository,
            SizeJunctionRepository sizeJunctionRepository) {
        this.birdTypeRepository = birdTypeRepository;
        this.cageSizeRepository = cageSizeRepository;
        this.sizeJunctionRepository = sizeJunctionRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getCageSizesByBirdType(@RequestParam("birdTypeId") int birdTypeId) {
        List<Map<String, Object>> result = new ArrayList<>();

        List<Integer> sizeIds = sizeJunctionRepository.findSizeIdsByBirdTypeId(birdTypeId);
        List<CageSize> cageSizes = cageSizeRepository.findAllById(sizeIds);

        for (CageSize cageSize : cageSizes) {
            Map<String, Object> sizeInfo = new HashMap<>();
            sizeInfo.put("sizeId", cageSize.getSizeId());
            sizeInfo.put("size", cageSize.getSize());

            SizeJunction sizeJunction = sizeJunctionRepository.findBySizeIdAndBirdTypeId(cageSize.getSizeId(), birdTypeId);
            sizeInfo.put("price", sizeJunction.getPrice());

            result.add(sizeInfo);
        }

        return result;
    }
}