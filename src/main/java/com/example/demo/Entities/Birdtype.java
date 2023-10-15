package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name ="bird_types")
public class Birdtype {
	@Id
	@Column(name ="birdtype_id")
	private int birdtypeId;
	@Column(name = "bird_name")
	private String birdName;
	@Column(name ="base_price")
	private int basePrice;
	@Column(name = "base_time")
	private int baseTime;
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public String getBirdName() {
		return birdName;
	}
	public void setBirdName(String birdName) {
		this.birdName = birdName;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public int getBaseTime() {
		return baseTime;
	}
	public void setBaseTime(int baseTime) {
		this.baseTime = baseTime;
	}
}
