package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class PerchJunctionKey implements Serializable {
	private int birdtypeId;
	private int perchId;
	
	public PerchJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getPerchId() {
		return perchId;
	}
	public void setPerchId(int colorId) {
		this.perchId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, perchId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerchJunctionKey other = (PerchJunctionKey) obj;
		return birdtypeId == other.birdtypeId && perchId == other.perchId;
	}
	
}
