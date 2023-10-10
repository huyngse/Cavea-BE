package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bird_types")
public class Birdtypes {
	@Id
	private int birdtypeId;
	@Column(name = "brid_name")
	private String birdname;
	@Column(name = "base_price")
	private int baseprice;
	@Column(name = "base_time")
	private int basetime;
	
}
