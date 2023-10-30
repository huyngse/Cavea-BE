package com.example.demo.Repo;

import com.example.demo.Entities.SpokeJunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpokeJunctionRepository extends JpaRepository<SpokeJunction, Integer> {
    @Query("SELECT sj FROM SpokeJunction sj WHERE sj.spokesId = :spokesId AND sj.birdTypeId = :birdTypeId")
    SpokeJunction findBySpokeIdAndBirdTypeId(@Param("spokesId") int spokeId, @Param("birdTypeId") int birdTypeId);

    @Query("SELECT sj.spokesId FROM SpokeJunction sj WHERE sj.birdTypeId = :birdTypeId")
    List<Integer> findSpokeIdsByBirdTypeId(@Param("birdTypeId") int birdTypeId);
}