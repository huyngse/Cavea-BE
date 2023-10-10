package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_material", schema = "production")
public class CageMaterial {
@Id
@Column(name = "material_id")
private int materialId;
@Column(name = "material")
private String material;


}
