package com.example.demo.Entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "regular_cages", schema = "production")
public class RegularCage {
	@Id
	@Column(name = "cage_id")
	private int cageId;
<<<<<<< HEAD
	@ManyToOne
	@JoinColumn(name = "birdtype_id", referencedColumnName = "birdtype_id")
	private Birdtype birdtype;
	@Column(name = "cage_code")
	private String cageCode;
=======
	@Column(name = "birdtype_id")
	private int birdtype;
>>>>>>> bae8eb462db280c2ce65fe41100d52b2c7b606d0
	@Column(name = "cage_name")
	private String cageName;
	@Column(name = "cage_price")
	private int price;
	@Column(name = "short_decription")
	private String shortDecript;
	@Column(name = "long_decription")
	private String longDecript;
	@OneToMany
<<<<<<< HEAD
	@JoinColumn(name = "cage_id", referencedColumnName = "cage_id")
=======
	@JoinColumn
>>>>>>> bae8eb462db280c2ce65fe41100d52b2c7b606d0
	private List<CageImages> imageList;
	@Column(name = "cage_color")
	private String color;
	@Column(name = "cage_material")
	private String material;
	@Column(name = "cage_size")
	private String size;
	@Column(name = "cage_spokes")
	private int spokes;
	@Column(name = "cage_feet")
	private String feet;
	@Column(name = "cage_perch")
	private String perch;
	@Column(name = "cage_cups")
	private String cups;
	@Column(name = "cage_hanger")
	private String hanger;
	@Column(name ="cage_rate")
	private float rate;
	@Column(name ="enabled")
	private boolean enabled;
	@Column(name = "discount")
	private float discount;
	@Column(name = "quantity")
	private int quantity;
	@Transient
	private int sold;
	public int getCageId() {
		return cageId;
	}
	public void setCageId(int cageId) {
		this.cageId = cageId;
	}
<<<<<<< HEAD
	public Birdtype getBirdtype() {
		return birdtype;
	}
	public void setBirdtype(Birdtype birdtype) {
		this.birdtype = birdtype;
	}
	
	public String getCageCode() {
		return cageCode;
	}
	public void setCageCode(String cageCode) {
		this.cageCode = cageCode;
	}
=======
	public int getBirdtype() {
		return birdtype;
	}
	public void setBirdtype(int birdtype) {
		this.birdtype = birdtype;
	}
>>>>>>> bae8eb462db280c2ce65fe41100d52b2c7b606d0
	public String getCageName() {
		return cageName;
	}
	public void setCageName(String cageName) {
		this.cageName = cageName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getShortDecript() {
		return shortDecript;
	}
	public void setShortDecript(String shortDecript) {
		this.shortDecript = shortDecript;
	}
	public String getLongDecript() {
		return longDecript;
	}
	public void setLongDecript(String longDecript) {
		this.longDecript = longDecript;
	}
	public List<CageImages> getImageList() {
		return imageList;
	}
	public void setImageList(List<CageImages> imageList) {
		this.imageList = imageList;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getSpokes() {
		return spokes;
	}
	public void setSpokes(int spokes) {
		this.spokes = spokes;
	}
	public String getFeet() {
		return feet;
	}
	public void setFeet(String feet) {
		this.feet = feet;
	}
	public String getPerch() {
		return perch;
	}
	public void setPerch(String perch) {
		this.perch = perch;
	}
	public String getCups() {
		return cups;
	}
	public void setCups(String cups) {
		this.cups = cups;
	}
	public String getHanger() {
		return hanger;
	}
	public void setHanger(String hanger) {
		this.hanger = hanger;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
}
