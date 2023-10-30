package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cage_spokes", schema = "production")
public class CageSpokes {
    @Id
    @Column(name = "spokes_id")
    private int spokesId;

    @Column(name = "spokes")
    private int spokes;

    public CageSpokes() {
    }

    public int getSpokesId() {
        return spokesId;
    }

    public void setSpokesId(int spokesId) {
        this.spokesId = spokesId;
    }

    public int getSpokes() {
        return spokes;
    }

    public void setSpokes(int spokes) {
        this.spokes = spokes;
    }
}