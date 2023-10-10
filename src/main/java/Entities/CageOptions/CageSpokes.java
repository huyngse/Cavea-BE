package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_spokes", schema = "production")
public class CageSpokes {
@Id
@Column(name = "spokes_id")
private int colorId;
@Column(name = "spokes")
private int spokes;


}
