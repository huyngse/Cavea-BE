package com.example.demo.Entities;

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
	
}
