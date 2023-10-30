package com.example.demo.Repo;

import com.example.demo.Entities.ShapeJunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShapeJunctionRepository extends JpaRepository<ShapeJunction, Integer> {
    @Query("SELECT sj FROM ShapeJunction sj WHERE sj.shapeId = :shapeId AND sj.birdTypeId = :birdTypeId")
    ShapeJunction findByShapeIdAndBirdTypeId(@Param("shapeId") int shapeId, @Param("birdTypeId") int birdTypeId);

    @Query("SELECT sj.shapeId FROM ShapeJunction sj WHERE sj.birdTypeId = :birdTypeId")
    List<Integer> findShapeIdsByBirdTypeId(@Param("birdTypeId") int birdTypeId);
}