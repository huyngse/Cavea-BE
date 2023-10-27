package com.example.demo.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
@Table(name = "regular_cage_images", schema = "production")
public class RegularCageImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int imageId;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cage_id", nullable = false)
    private RegularCage regularCage;

    @Column(name = "is_main", nullable = false)
    private boolean isMain;

    public RegularCageImage() {
    }

    public RegularCageImage(int imageId, String imageUrl, RegularCage regularCage, boolean isMain) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.regularCage = regularCage;
        this.isMain = isMain;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRegularCage(RegularCage regularCage) {
        this.regularCage = regularCage;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public int getImageId() {
        return imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
@JsonIgnore
    public RegularCage getRegularCage() {
        return regularCage;
    }
    public int getCageId() {return regularCage.getCageId();}
}