package com.example.demo.Repo;

import com.example.demo.Entities.MaterialJunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialJunctionRepository extends JpaRepository<MaterialJunction, Integer> {
    @Query("SELECT mj FROM MaterialJunction mj WHERE mj.materialId = :materialId AND mj.birdTypeId = :birdTypeId")
    MaterialJunction findByMaterialIdAndBirdTypeId(@Param("materialId") int materialId, @Param("birdTypeId") int birdTypeId);

    @Query("SELECT mj.materialId FROM MaterialJunction mj WHERE mj.birdTypeId = :birdTypeId")
    List<Integer> findMaterialIdsByBirdTypeId(@Param("birdTypeId") int birdTypeId);
}