package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "material_junctions")
@IdClass(MaterialJunctionId.class)
public class MaterialJunction {
    @Id
    @Column(name = "material_id")
    private int materialId;

    @Id
    @Column(name = "birdtype_id")
    private int birdTypeId;

    @Column(name = "price")
    private int price;

    @Column(name = "time")
    private int time;

    // Getters and setters

    public MaterialJunction() {
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