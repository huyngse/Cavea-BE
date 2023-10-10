package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageHanger;
import Entities.JunctionKey.HangerJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "hanger_junctions")
public class HangerJunctions {
	@EmbeddedId
	private HangerJunctionKey id;

	@ManyToOne
	@MapsId("hangerId")
	@JoinColumn(name = "hanger_id")
	private CageHanger hanger;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public HangerJunctions() {
	}
	public HangerJunctionKey getId() {
		return id;
	}
	public void setId(HangerJunctionKey id) {
		this.id = id;
	}
	public CageHanger getHanger() {
		return hanger;
	}
	public void setHanger(CageHanger hanger) {
		this.hanger = hanger;
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
