package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_size", schema = "production")
public class CageSize {
@Id
@Column(name = "size_id")
private int sizeId;
@Column(name = "size")
private String size;


}
