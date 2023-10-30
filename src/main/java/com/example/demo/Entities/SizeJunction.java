package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "size_junctions")
@IdClass(SizeJunctionId.class)
public class SizeJunction {
    @Id
    @Column(name = "size_id")
    private int sizeId;

    @Id
    @Column(name = "birdtype_id")
    private int birdTypeId;

    @Column(name = "price")
    private int price;

    @Column(name = "time")
    private int time;

    public SizeJunction() {
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
