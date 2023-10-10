package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_feet", schema = "production")
public class CageFeet {
@Id
@Column(name = "feet_id")
private int colorId;
@Column(name = "feet")
private String color;


}
