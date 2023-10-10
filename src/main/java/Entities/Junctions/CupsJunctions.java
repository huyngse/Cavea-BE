package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageCups;
import Entities.JunctionKey.CupsJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "cups_junctions")
public class CupsJunctions {
	@EmbeddedId
	private CupsJunctionKey id;

	@ManyToOne
	@MapsId("cupsId")
	@JoinColumn(name = "cups_id")
	private CageCups cups;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public CupsJunctions() {
	}
	public CupsJunctionKey getId() {
		return id;
	}
	public void setId(CupsJunctionKey id) {
		this.id = id;
	}
	public CageCups getCups() {
		return cups;
	}
	public void setCups(CageCups cups) {
		this.cups = cups;
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
