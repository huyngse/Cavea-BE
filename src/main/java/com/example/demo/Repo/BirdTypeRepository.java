package com.example.demo.Repo;
import com.example.demo.Entities.BirdType;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BirdTypeRepository extends JpaRepository<BirdType, Integer> {

}