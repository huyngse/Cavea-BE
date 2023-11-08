package com.example.demo.Repo;

import com.example.demo.Entities.sales.CustomCageOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomCageOrdersRepository extends JpaRepository<CustomCageOrders, Integer> {
    Optional<CustomCageOrders> getCustomCageOrdersByOrderId(Integer id);
}