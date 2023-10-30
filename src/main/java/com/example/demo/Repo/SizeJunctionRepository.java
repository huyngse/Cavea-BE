package com.example.demo.Repo;

import com.example.demo.Entities.SizeJunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeJunctionRepository extends JpaRepository<SizeJunction, Integer> {
    @Query("SELECT sj FROM SizeJunction sj WHERE sj.sizeId = :sizeId AND sj.birdTypeId = :birdTypeId")
    SizeJunction findBySizeIdAndBirdTypeId(@Param("sizeId") int sizeId, @Param("birdTypeId") int birdTypeId);

    @Query("SELECT sj.sizeId FROM SizeJunction sj WHERE sj.birdTypeId = :birdTypeId")
    List<Integer> findSizeIdsByBirdTypeId(@Param("birdTypeId") int birdTypeId);
}