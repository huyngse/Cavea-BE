package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class HangerJunctionKey implements Serializable {
	private int birdtypeId;
	private int hangerId;
	
	public HangerJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getHangerId() {
		return hangerId;
	}
	public void setHangerId(int colorId) {
		this.hangerId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, hangerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangerJunctionKey other = (HangerJunctionKey) obj;
		return birdtypeId == other.birdtypeId && hangerId == other.hangerId;
	}
	
}
