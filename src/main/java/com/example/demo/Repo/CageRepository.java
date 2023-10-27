package com.example.demo.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entities.RegularCage;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CageRepository extends JpaRepository<RegularCage, Integer> {
    List<RegularCage> findByCageNameContainingIgnoreCase(String cageName);
    @Query(value="SELECT * FROM production.regular_cages", nativeQuery = true)
    public List<RegularCage> getAll();
}