package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class MaterialJunctionId implements Serializable {
    private int materialId;
    private int birdTypeId;

    public MaterialJunctionId() {
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getBirdTypeId() {
        return birdTypeId;
    }

    public void setBirdTypeId(int birdTypeId) {
        this.birdTypeId = birdTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialJunctionId that = (MaterialJunctionId) o;
        return materialId == that.materialId && birdTypeId == that.birdTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId, birdTypeId);
    }
}
