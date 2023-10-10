package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageSize;
import Entities.JunctionKey.SizeJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "size_junctions")
public class SizeJunctions {
	@EmbeddedId
	private SizeJunctionKey id;

	@ManyToOne
	@MapsId("sizeId")
	@JoinColumn(name = "size_id")
	private CageSize size;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public SizeJunctions() {
	}
	public SizeJunctionKey getId() {
		return id;
	}
	public void setId(SizeJunctionKey id) {
		this.id = id;
	}
	public CageSize getSize() {
		return size;
	}
	public void setSize(CageSize size) {
		this.size = size;
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
