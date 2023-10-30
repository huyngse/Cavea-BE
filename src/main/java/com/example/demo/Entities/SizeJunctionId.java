package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class SizeJunctionId implements Serializable {
    private int sizeId;
    private int birdTypeId;

    public SizeJunctionId() {
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
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
        SizeJunctionId that = (SizeJunctionId) o;
        return sizeId == that.sizeId && birdTypeId == that.birdTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, birdTypeId);
    }
}
