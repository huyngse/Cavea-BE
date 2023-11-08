package com.example.demo.Repo;

import com.example.demo.DTO.BirdTypesDTO;
import com.example.demo.Entities.dbo.BirdTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdTypesRepo extends JpaRepository<BirdTypes, Integer> {
    @Query(value = "SELECT * FROM bird_types", nativeQuery = true)
    List<BirdTypes> get();

    @Query(value = "  SELECT A.birdtype_id as 'birdtypeId', A.bird_name as 'birdName', A.base_time as 'basePrice', A.base_price as 'basePrice', A.img, B.discount\n" +
            "  FROM [dbo].[bird_types] A \n" +
            "  LEFT JOIN [production].[regular_cages] B ON A.birdtype_id = B.cage_id", nativeQuery = true)
    List<BirdTypesDTO> getAll();
}