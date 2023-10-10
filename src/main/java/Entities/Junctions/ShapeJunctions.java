package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageShape;
import Entities.JunctionKey.ShapeJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "shape_junctions")
public class ShapeJunctions {
	@EmbeddedId
	private ShapeJunctionKey id;

	@ManyToOne
	@MapsId("shapeId")
	@JoinColumn(name = "shape_id")
	private CageShape shape;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public ShapeJunctions() {
	}
	public ShapeJunctionKey getId() {
		return id;
	}
	public void setId(ShapeJunctionKey id) {
		this.id = id;
	}
	public CageShape getShape() {
		return shape;
	}
	public void setShape(CageShape shape) {
		this.shape = shape;
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
