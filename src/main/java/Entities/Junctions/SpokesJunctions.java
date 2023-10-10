package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageSpokes;
import Entities.JunctionKey.SpokesJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "spokes_junctions")
public class SpokesJunctions {
	@EmbeddedId
	private SpokesJunctionKey id;

	@ManyToOne
	@MapsId("spokesId")
	@JoinColumn(name = "spokes_id")
	private CageSpokes spokes;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public SpokesJunctions() {
	}
	public SpokesJunctionKey getId() {
		return id;
	}
	public void setId(SpokesJunctionKey id) {
		this.id = id;
	}
	public CageSpokes getSpokes() {
		return spokes;
	}
	public void setSpokes(CageSpokes spokes) {
		this.spokes = spokes;
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
