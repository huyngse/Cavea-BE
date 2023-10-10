package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class FeetJunctionKey implements Serializable {
	private int birdtypeId;
	private int  feetId;
	
	public FeetJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getColorId() {
		return feetId;
	}
	public void setColorId(int colorId) {
		this.feetId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, feetId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeetJunctionKey other = (FeetJunctionKey) obj;
		return birdtypeId == other.birdtypeId && feetId == other.feetId;
	}
	
}
