package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class SpokeJunctionId implements Serializable {
    private int spokesId;
    private int birdTypeId;

    public SpokeJunctionId() {
    }

    public int getSpokesId() {
        return spokesId;
    }

    public void setSpokesId(int spokesId) {
        this.spokesId = spokesId;
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
        SpokeJunctionId that = (SpokeJunctionId) o;
        return spokesId == that.spokesId && birdTypeId == that.birdTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(spokesId, birdTypeId);
    }
}
