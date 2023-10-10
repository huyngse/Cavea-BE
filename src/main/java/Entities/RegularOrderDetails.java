package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items", schema = "sales")
public class RegularOrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "order_id")
	private int orderId;
	@JoinColumn(name = "cage_id", referencedColumnName = "cage_id")
	private RegularCage cage;
	@Column(name = "order_quantity")
	private int quantity;
	@Column(name = "list_price")
	private int price;
	
}
