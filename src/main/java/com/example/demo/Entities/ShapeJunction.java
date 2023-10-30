package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "shape_junctions")
@IdClass(ShapeJunctionId.class)
public class ShapeJunction {
    @Id
    @Column(name = "shape_id")
    private int shapeId;

    @Id
    @Column(name = "birdtype_id")
    private int birdTypeId;

    @Column(name = "price")
    private int price;

    @Column(name = "time")
    private int time;

    public ShapeJunction() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}