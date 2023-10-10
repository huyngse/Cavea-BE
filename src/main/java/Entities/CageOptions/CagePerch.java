package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_perch", schema = "production")
public class CagePerch {
@Id
@Column(name = "perch_id")
private int perchId;
@Column(name = "perch")
private String perch;


}
