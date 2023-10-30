package com.example.demo.Repo;

import com.example.demo.Entities.CageSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageSizeRepository extends JpaRepository<CageSize, Integer> {
}