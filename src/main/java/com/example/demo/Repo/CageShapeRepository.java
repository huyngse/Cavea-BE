package com.example.demo.Repo;

import com.example.demo.Entities.CageShape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageShapeRepository extends JpaRepository<CageShape, Integer> {
}