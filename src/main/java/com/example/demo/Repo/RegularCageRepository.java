package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.RegularCage;

public interface RegularCageRepository extends JpaRepository<RegularCage, Integer> {
	@Query(value="SELECT * FROM production.regular_cages", nativeQuery = true)
	public List<RegularCage> findAll();
	@Query(value ="SELECT * FROM production.regular_cages WHERE birdtype_id = :birdtypeId", nativeQuery = true)
	public List<RegularCage> findAllByBirdtype(@Param("birdtypeId") int birdtypeId);
	@Query(value ="SELECT * FROM production.regular_cages WHERE cage_name LIKE %:search%", nativeQuery = true)
	public List<RegularCage> searchAllByName(@Param("search") String search);
	@Query(value ="SELECT * FROM production.regular_cages WHERE cage_id = :cageId", nativeQuery = true)
	public RegularCage findById(@Param("cageId") int cageId);
}
