package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_colors", schema = "production")
public class CageColor {
@Id
@Column(name = "color_id")
private int colorId;
@Column(name = "color")
private String color;


}
