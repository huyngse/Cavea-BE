package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageColor;
import Entities.JunctionKey.ColorJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "color_junctions")
public class ColorJunctions {
	@EmbeddedId
	private ColorJunctionKey id;

	@ManyToOne
	@MapsId("colorId")
	@JoinColumn(name = "color_id")
	private CageColor color;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public ColorJunctions() {
	}
	public ColorJunctionKey getId() {
		return id;
	}
	public void setId(ColorJunctionKey id) {
		this.id = id;
	}
	public CageColor getColor() {
		return color;
	}
	public void setColor(CageColor color) {
		this.color = color;
	}
	public Birdtypes getBirdtype() {
		return birdtype;
	}
	public void setBirdtype(Birdtypes birdtype) {
		this.birdtype = birdtype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}
