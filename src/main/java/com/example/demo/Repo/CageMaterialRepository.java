package com.example.demo.Repo;

import com.example.demo.Entities.CageMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageMaterialRepository extends JpaRepository<CageMaterial, Integer> {
}
