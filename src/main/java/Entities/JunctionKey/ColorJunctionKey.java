package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class ColorJunctionKey implements Serializable {
	private int birdtypeId;
	private int colorId;
	
	public ColorJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, colorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorJunctionKey other = (ColorJunctionKey) obj;
		return birdtypeId == other.birdtypeId && colorId == other.colorId;
	}
	
}
