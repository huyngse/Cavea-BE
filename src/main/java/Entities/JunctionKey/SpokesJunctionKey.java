package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class SpokesJunctionKey implements Serializable {
	private int birdtypeId;
	private int spokesId;
	
	public SpokesJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getSpokesId() {
		return spokesId;
	}
	public void setSpokesId(int colorId) {
		this.spokesId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, spokesId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpokesJunctionKey other = (SpokesJunctionKey) obj;
		return birdtypeId == other.birdtypeId && spokesId == other.spokesId;
	}
	
}
