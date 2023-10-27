package com.example.demo.DTO;

import com.example.demo.Entities.RegularCage;
import com.example.demo.Entities.RegularOrderItem;

public class OrderItemDTO {
	private int Id;
	private int orderId;
	private int cageId;
	private int quantity;
	private int price;
	private RegularCage cage;
	
	public OrderItemDTO() {
	}

	public OrderItemDTO(RegularOrderItem orderItem ) {
		
		this.Id = orderItem.getItemId();
		this.orderId = orderItem.getOrderId();
		this.quantity = orderItem.getQuantity();
		this.price = orderItem.getListPrice();
	}
	
	public OrderItemDTO(RegularOrderItem orderItem, RegularCage cage) {
		this.Id = orderItem.getItemId();
		this.orderId = orderItem.getOrderId();
		this.cageId = cage.getCageId();
		this.quantity = orderItem.getQuantity();
		this.price = orderItem.getListPrice();
		this.setCage(cage);
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCageId() {
		return cageId;
	}
	public void setCageId(int cageId) {
		this.cageId = cageId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public RegularCage getCage() {
		return cage;
	}
	public void setCage(RegularCage cage) {
		this.cage = cage;
	}
	public long getTotal() {
		return this.price*this.quantity;
	}
}
