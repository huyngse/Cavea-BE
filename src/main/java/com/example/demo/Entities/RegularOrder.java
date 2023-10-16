package com.example.demo.Entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders", schema = "sales")
public class RegularOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "order_status")
	private String orderStatus;
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	@Column(name = "order_note")
	private String orderNote;
	@Column(name = "shipped_date")
	private LocalDateTime shippedDate;
	@Column(name = "staff_id")
	private int staffId;
	@Column(name = "total_amount")
	private float totalAmount;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private List<RegularOrderItem> itemList;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(LocalDateTime shippedDate) {
		this.shippedDate = shippedDate;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<RegularOrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<RegularOrderItem> itemList) {
		this.itemList = itemList;
	}

}
