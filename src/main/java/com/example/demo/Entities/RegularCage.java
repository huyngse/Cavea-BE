package com.example.demo.Entities;
import jakarta.persistence.*;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "regular_cages", schema = "production")
public class RegularCage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cage_id")
    private int cageId;

    @ManyToOne
    @JoinColumn(name = "birdtype_id", referencedColumnName = "birdtype_id", nullable = false)
    private BirdType birdType;

    @Column(name = "cage_code")
    private String cageCode;

    @Column(name = "cage_name", nullable = false)
    private String cageName;

    @Column(name = "cage_price", nullable = false)
    private int cagePrice;

    @Column(name = "discount", nullable = false)
    private float discount;

    @Column(name = "short_decription", nullable = false)
    private String shortDescription;

    @Column(name = "long_decription", nullable = false)
    private String longDescription;

    @Column(name = "cage_color")
    private String cageColor;

    @Getter
    @Column(name = "cage_material")
    private String cageMaterial;

    @Getter
    @Column(name = "cage_shape")
    private String cageShape;

    @Getter
    @Column(name = "cage_size")
    private String cageSize;

    @Getter
    @Column(name = "cage_spokes")
    private Integer cageSpokes;

    @Getter
    @Column(name = "cage_feet")
    private String cageFeet;

    @Column(name = "cage_perch")
    private String cagePerch;

    @Column(name = "cage_cups")
    private String cageCups;

    @Column(name = "cage_hanger")
    private String cageHanger;

    @Column(name = "cage_rate", nullable = false)
    private float cageRate;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "regularCage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegularCageImage> imageList;
    public RegularCage() {
    }


    public int getCageId() {
        return cageId;
    }

    public void setCageId(int cageId) {
        this.cageId = cageId;
    }



    public String getCageCode() {
        return cageCode;
    }

    public void setCageCode(String cageCode) {
        this.cageCode = cageCode;
    }

    public String getCageName() {
        return cageName;
    }

    public void setCageName(String cageName) {
        this.cageName = cageName;
    }

    public int getCagePrice() {
        return cagePrice;
    }

    public void setCagePrice(int cagePrice) {
        this.cagePrice = cagePrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getCageColor() {
        return cageColor;
    }

    public void setCageColor(String cageColor) {
        this.cageColor = cageColor;
    }

    public void setCageMaterial(String cageMaterial) {
        this.cageMaterial = cageMaterial;
    }

    public void setCageShape(String cageShape) {
        this.cageShape = cageShape;
    }

    public void setCageSize(String cageSize) {
        this.cageSize = cageSize;
    }

    public void setCageSpokes(Integer cageSpokes) {
        this.cageSpokes = cageSpokes;
    }

    public void setCageFeet(String cageFeet) {
        this.cageFeet = cageFeet;
    }

    public String getCagePerch() {
        return cagePerch;
    }

    public void setCagePerch(String cagePerch) {
        this.cagePerch = cagePerch;
    }

    public String getCageCups() {
        return cageCups;
    }

    public void setCageCups(String cageCups) {
        this.cageCups = cageCups;
    }

    public String getCageHanger() {
        return cageHanger;
    }

    public void setCageHanger(String cageHanger) {
        this.cageHanger = cageHanger;
    }

    public float getCageRate() {
        return cageRate;
    }

    public void setCageRate(float cageRate) {
        this.cageRate = cageRate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BirdType getBirdType() {
        return birdType;
    }

    public void setBirdType(BirdType birdType) {
        this.birdType = birdType;
    }

    public List<RegularCageImage> getCageImages() {
        return imageList;
    }

    public void setCageImages(List<RegularCageImage> cageImages) {
        this.imageList = cageImages;
    }
}