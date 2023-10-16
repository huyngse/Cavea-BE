package com.example.demo.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "payment", schema = "sales")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int paymentId;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "pay_date")
	private LocalDateTime payDate;
	@Column(name = "method")
	private String method;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getPayDate() {
		return payDate;
	}
	public void setPayDate(LocalDateTime payDate) {
		this.payDate = payDate;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
