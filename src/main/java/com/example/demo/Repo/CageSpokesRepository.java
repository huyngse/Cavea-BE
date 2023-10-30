package com.example.demo.Repo;

import com.example.demo.Entities.CageSpokes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageSpokesRepository extends JpaRepository<CageSpokes, Integer> {
}
