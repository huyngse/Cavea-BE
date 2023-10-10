package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class SizeJunctionKey implements Serializable {
	private int birdtypeId;
	private int sizeId;
	
	public SizeJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int colorId) {
		this.sizeId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, sizeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeJunctionKey other = (SizeJunctionKey) obj;
		return birdtypeId == other.birdtypeId && sizeId == other.sizeId;
	}
	
}
