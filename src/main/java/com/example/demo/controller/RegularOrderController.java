package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.RegularOrderDTO;
import com.example.demo.Entities.RegularOrder;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/order")
public class RegularOrderController {
	@Autowired
	OrderService orderService;
	@PostMapping("/create")
	public RegularOrder saveNewOrder(@RequestBody RegularOrderDTO orderDTO) {
		RegularOrder newOrder = orderService.save(orderDTO);
		return newOrder;
	}
}
