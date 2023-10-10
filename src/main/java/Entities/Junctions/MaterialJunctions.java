package Entities.Junctions;

import Entities.Birdtypes;
import Entities.CageOptions.CageMaterial;
import Entities.JunctionKey.MaterialJunctionKey;
import jakarta.persistence.*;

@Entity
@Table(name = "material_junctions")
public class MaterialJunctions {
	@EmbeddedId
	private MaterialJunctionKey id;

	@ManyToOne
	@MapsId("materialId")
	@JoinColumn(name = "material_id")
	private CageMaterial material;

	@ManyToOne
	@MapsId("birdtypeId")
	@JoinColumn(name = "birdtype_id")
	private Birdtypes birdtype;
	
	@Column(name = "price")
	private int price;
	@Column(name = "time")
	private int time;
	public MaterialJunctions() {
	}
	public  MaterialJunctionKey getId() {
		return id;
	}
	public void setId(MaterialJunctionKey id) {
		this.id = id;
	}
	public CageMaterial getMaterial() {
		return material;
	}
	public void setMaterial(CageMaterial material) {
		this.material = material;
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
