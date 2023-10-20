package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DTO.RegularOrderDTO;
import com.example.demo.Entities.RegularOrder;
import com.example.demo.Repo.OrderRepository;

public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	public RegularOrder getOrderById(int id) {
		return orderRepository.getOrderById(id);
	}

	public RegularOrder save(RegularOrderDTO orderDTO) {
		RegularOrder newOrder = new RegularOrder(orderDTO);
		orderRepository.save(newOrder);
		return newOrder;
	}
}
