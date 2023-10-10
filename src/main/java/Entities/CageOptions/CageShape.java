package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_shape", schema = "production")
public class CageShape {
@Id
@Column(name = "shape_id")
private int shapeId;
@Column(name = "shape")
private String shape;


}
