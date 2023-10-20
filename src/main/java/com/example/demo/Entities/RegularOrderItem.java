package com.example.demo.Entities;

import com.example.demo.DTO.OrderItemDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items", schema = "sales")
public class RegularOrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "cage_id")
	private int cageId;
	@Column(name = "order_quantity")
	private int quantity;
	@Column(name = "list_price")
	private int listPrice;

	public RegularOrderItem() {
	}

	public RegularOrderItem(OrderItemDTO orderItemDTO) {
		this.itemId = orderItemDTO.getId();
		this.orderId = orderItemDTO.getOrderId();
		this.cageId = orderItemDTO.getCageId();
		this.quantity = orderItemDTO.getQuantity();
		this.listPrice = orderItemDTO.getPrice();
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public int getListPrice() {
		return listPrice;
	}

	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}

}
