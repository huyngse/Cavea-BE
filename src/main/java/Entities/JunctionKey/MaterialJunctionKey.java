package Entities.JunctionKey;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class MaterialJunctionKey implements Serializable {
	private int birdtypeId;
	private int materialId;
	
	public MaterialJunctionKey() {
	}
	public int getBirdtypeId() {
		return birdtypeId;
	}
	public void setBirdtypeId(int birdtypeId) {
		this.birdtypeId = birdtypeId;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int colorId) {
		this.materialId = colorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birdtypeId, materialId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialJunctionKey other = (MaterialJunctionKey) obj;
		return birdtypeId == other.birdtypeId && materialId == other.materialId;
	}
	
}
