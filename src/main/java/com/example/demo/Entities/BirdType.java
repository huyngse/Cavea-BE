package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bird_types")
public class BirdType {
    @Id
    @Column(name = "birdtype_id")
    private int birdTypeId;
    @Column(name = "bird_name")
    private String birdName;
    @Column(name = "base_price")
    private int basePrice;
    @Column(name = "base_time")
    private int baseTime;
    @Column(name = "bird_image_url")
    private String birdImageUrl;

    public int getBirdTypeId() {
        return birdTypeId;
    }

    public void setBirdTypeId(int birdTypeId) {
        this.birdTypeId = birdTypeId;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(int baseTime) {
        this.baseTime = baseTime;
    }

    public String getBirdImageUrl() {
        return birdImageUrl;
    }

    public void setBirdImageUrl(String birdImageUrl) {
        this.birdImageUrl = birdImageUrl;
    }
}

