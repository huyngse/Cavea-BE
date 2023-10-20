package com.example.demo.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Entities.Customer;
import com.example.demo.Entities.Payment;
import com.example.demo.Entities.RegularOrder;
import com.example.demo.Entities.RegularOrderItem;

public class RegularOrderDTO {
	private int id;
	private int customerId;
	private Customer customer;
	private String status;
	private LocalDateTime orderDate;
	private LocalDateTime shippedDate;
	private String note;
	
	private int staffId;
	private float totalAmount;
	private List<OrderItemDTO> orderItemList;
	private Payment payment;
	
	public RegularOrderDTO() {
		super();
	}
	public RegularOrderDTO(RegularOrder order, Customer customer, List<OrderItemDTO> orderItemDTO, Payment payment) {
		this.id=order.getOrderId();
		this.customerId = customer.getCustomerId();
		this.status = order.getOrderStatus();
		this.orderDate = LocalDateTime.now();
		this.note = order.getOrderNote();
		this.customer = customer;
		this.staffId = order.getStaffId();
		this.totalAmount = order.getTotalAmount();
		this.orderItemList = orderItemDTO;
		this.payment = payment;
	}
	
	public LocalDateTime getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(LocalDateTime shippedDate) {
		this.shippedDate = shippedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderTime) {
		this.orderDate = orderTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	public List<OrderItemDTO> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDTO> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}