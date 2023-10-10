package Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "orders", schema = "sales")
public class RegularOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	//Mapping Customer table
	private int customerId;
	@Column(name = "order_status")
	private String orderStatus;
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	@Column(name = "shipped_date")
	private LocalDateTime shippedDate;
	@Column(name = "staff_id")
	private Accounts staffId;
	@Column(name = "total_amount")
	private float totalAmount;
	private List<RegularOrderDetail>

}
