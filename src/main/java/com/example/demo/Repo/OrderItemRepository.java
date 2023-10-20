package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.RegularOrderItem;

public interface OrderItemRepository extends JpaRepository<RegularOrderItem, Integer> {
	@Query("SELECT * FROM sales.order_items oi WHERE oi.item_id = :itemId")
	public RegularOrderItem getOrderItemById(@Param("itemId") int itemId);
	@Query("SELECT SUM(oi.order_quantity) FROM sales.order_items oi WHERE oi.cage_id = :cageId")
	public Integer getSoldByCageId(@Param("cageId") int cageId);
	
}
