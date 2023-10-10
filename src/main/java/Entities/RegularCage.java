package Entities;

import java.util.List;

import Entities.CageOptions.CageColor;
import Entities.CageOptions.CageCups;
import Entities.CageOptions.CageFeet;
import Entities.CageOptions.CageHanger;
import Entities.CageOptions.CageMaterial;
import Entities.CageOptions.CagePerch;
import Entities.CageOptions.CageShape;
import Entities.CageOptions.CageSize;
import Entities.CageOptions.CageSpokes;
import jakarta.persistence.*;

@Entity
@Table(name = "regular_cages", schema = "production")
public class RegularCage {
	@Id
	@Column(name = "cage_id")
	private int cageId;
	@ManyToOne
	@JoinColumn(name = "birdtype_id", referencedColumnName = "birdtype_id")
	private Birdtypes birdtype;
	@Column(name = "cage_name")
	private String cageName;
	@Column(name = "cage_price")
	private int price;
	@Column(name = "short_decription")
	private String shortDecript;
	@Column(name = "long_decription")
	private String longDecript;
	@OneToMany
	@JoinColumn(name ="cage_id", referencedColumnName = "image_id")
	private List<CageImages> imageList;
	@ManyToOne
	@JoinColumn(name = "cage_color_id", referencedColumnName = "color_id")
	private CageColor color;
	@ManyToOne
	@JoinColumn(name = "cage_material_id", referencedColumnName = "material_id")
	private CageMaterial material;
	@ManyToOne
	@JoinColumn(name = "cage_shape_id", referencedColumnName = "shape_id")
	private CageShape shape;
	@ManyToOne
	@JoinColumn(name = "cage_size_id", referencedColumnName = "size_id")
	private CageSize size;
	@ManyToOne
	@JoinColumn(name = "cage_spokes_id", referencedColumnName = "spokes_id")
	private CageSpokes spokes;
	@ManyToOne
	@JoinColumn(name = "cage_feet_id", referencedColumnName = "feet_id")
	private CageFeet feet;
	@ManyToOne
	@JoinColumn(name = "cage_perch_id", referencedColumnName = "perch_id")
	private CagePerch perch;
	@ManyToOne
	@JoinColumn(name = "cage_cups_id", referencedColumnName = "cups_id")
	private CageCups cups;
	@ManyToOne
	@JoinColumn(name = "cage_hanger_id", referencedColumnName = "hanger_id")
	private CageHanger hanger;
	private float rate;
	private boolean enabled;
	private float discount;
	private int quantity;
	public int getCageId() {
		return cageId;
	}
	public void setCageId(int cageId) {
		this.cageId = cageId;
	}
	public Birdtypes getBirdtype() {
		return birdtype;
	}
	public void setBirdtype(Birdtypes birdtype) {
		this.birdtype = birdtype;
	}
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
	public CageColor getColor() {
		return color;
	}
	public void setColor(CageColor color) {
		this.color = color;
	}
	public CageMaterial getMaterial() {
		return material;
	}
	public void setMaterial(CageMaterial material) {
		this.material = material;
	}
	public CageShape getShape() {
		return shape;
	}
	public void setShape(CageShape shape) {
		this.shape = shape;
	}
	public CageSize getSize() {
		return size;
	}
	public void setSize(CageSize size) {
		this.size = size;
	}
	public CageSpokes getSpokes() {
		return spokes;
	}
	public void setSpokes(CageSpokes spokes) {
		this.spokes = spokes;
	}
	public CageFeet getFeet() {
		return feet;
	}
	public void setFeet(CageFeet feet) {
		this.feet = feet;
	}
	public CagePerch getPerch() {
		return perch;
	}
	public void setPerch(CagePerch perch) {
		this.perch = perch;
	}
	public CageCups getCups() {
		return cups;
	}
	public void setCups(CageCups cups) {
		this.cups = cups;
	}
	public CageHanger getHanger() {
		return hanger;
	}
	public void setHanger(CageHanger hanger) {
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
	
}
