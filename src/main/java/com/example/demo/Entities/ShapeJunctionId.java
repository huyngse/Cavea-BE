package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class ShapeJunctionId implements Serializable {
    private int shapeId;
    private int birdTypeId;

    public ShapeJunctionId() {
    }

    public int getShapeId() {
        return shapeId;
    }

    public void setShapeId(int shapeId) {
        this.shapeId = shapeId;
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
        ShapeJunctionId that = (ShapeJunctionId) o;
        return shapeId == that.shapeId && birdTypeId == that.birdTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeId, birdTypeId);
    }
}