package Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "payment", schema = "sales")
public class Payment {
	@Id
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "pay_date")
	private LocalDateTime payDate;
	@Column(name = "method")
	private String method;
	public Payment() {
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
