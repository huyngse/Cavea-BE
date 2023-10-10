package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class ShapeJunctionKey implements Serializable {
	private int birdtypeId;
	private int shapeId;
	
	public ShapeJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getShapeId() {
		return shapeId;
	}
	public void setShapeId(int colorId) {
		this.shapeId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, shapeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShapeJunctionKey other = (ShapeJunctionKey) obj;
		return birdtypeId == other.birdtypeId && shapeId == other.shapeId;
	}
	
}
