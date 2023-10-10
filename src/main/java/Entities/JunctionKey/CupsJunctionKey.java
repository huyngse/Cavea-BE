package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class CupsJunctionKey implements Serializable {
	private int birdtypeId;
	private int cupsId;
	
	public CupsJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getCupsId() {
		return cupsId;
	}
	public void setCupsId(int colorId) {
		this.cupsId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, cupsId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CupsJunctionKey other = (CupsJunctionKey) obj;
		return birdtypeId == other.birdtypeId && cupsId == other.cupsId;
	}
	
}
