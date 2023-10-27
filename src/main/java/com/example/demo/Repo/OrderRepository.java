package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.RegularOrder;

public interface OrderRepository extends JpaRepository<RegularOrder, Integer>{
	@Query("SELECT * FROM sales.orders o WHERE o.order_id = :orderId")
	public RegularOrder getOrderById(@Param("orderId") int orderId);
	@Query("SELECT * FROM sales.orders o WHERE o.order_status = :orderStatus")
	public List<RegularOrder> getALlOrderBystatus(@Param("orderStatus") String orderStatus);
	@Query("SELECT * FROM sales.orders o WHERE o.customer_id = :customerId")
	public List<RegularOrder> getAllOrderByCustomerId(@Param("customerId") int customerId);
	@Query("SELECT * FROM sales.orders o WHERE o.customer_id = :customerId AND o.order_status = :orderStatus")
	public List<RegularOrder> getOrderByCustomerIdWithStatus(@Param("customerId") int customerId, @Param("orderStatus") String orderStatus);
}
