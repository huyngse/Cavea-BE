package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DTO.OrderItemDTO;
import com.example.demo.DTO.RegularOrderDTO;
import com.example.demo.Entities.RegularCage;
import com.example.demo.Entities.RegularOrderItem;
import com.example.demo.Repo.OrderItemRepository;

public class OrderItemService {
	@Autowired
	RegularCageService cageService;
	@Autowired
	OrderItemRepository itemRepository;
	public List<RegularOrderItem> addOrderItem(RegularOrderDTO orderDTO){
		List<RegularOrderItem> orderItemList = new ArrayList<>();
		for (OrderItemDTO itemDTO : orderDTO.getOrderItemList()) {
			RegularOrderItem item = new RegularOrderItem(itemDTO);
			orderItemList.add(item);
			itemRepository.save(item);
		}
		return orderItemList;
	}
}
