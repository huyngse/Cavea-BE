package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CagePerch;
import Entities.JunctionKey.PerchJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "perch_junctions")
public class PerchJunctions {
	@EmbeddedId
	private PerchJunctionKey id;

	@ManyToOne
	@MapsId("perchId")
	@JoinColumn(name = "perch_id")
	private CagePerch perch;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public PerchJunctions() {
	}
	public PerchJunctionKey getId() {
		return id;
	}
	public void setId(PerchJunctionKey id) {
		this.id = id;
	}
	public CagePerch getPerch() {
		return perch;
	}
	public void setPerch(CagePerch perch) {
		this.perch = perch;
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
