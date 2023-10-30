package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "spoke_junctions")
@IdClass(SpokeJunctionId.class)
public class SpokeJunction {
    @Id
    @Column(name = "spoke_id")
    private int spokesId;

    @Id
    @Column(name = "birdtype_id")
    private int birdTypeId;

    @Column(name = "price")
    private int price;

    @Column(name = "time")
    private int time;

    public SpokeJunction() {
    }

    public int getSpokesId() {
        return spokesId;
    }

    public void setSpokesId(int spokeId) {
        this.spokesId = spokeId;
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