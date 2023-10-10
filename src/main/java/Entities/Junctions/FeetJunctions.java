package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageFeet;
import Entities.JunctionKey.FeetJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "feet_junctions")
public class FeetJunctions {
	@EmbeddedId
	private FeetJunctionKey id;

	@ManyToOne
	@MapsId("feetId")
	@JoinColumn(name = "feet_id")
	private CageFeet feet;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public FeetJunctions() {
	}
	public FeetJunctionKey getId() {
		return id;
	}
	public void setId(FeetJunctionKey id) {
		this.id = id;
	}
	public CageFeet getColor() {
		return feet;
	}
	public void setColor(CageFeet feet) {
		this.color = feet;
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
