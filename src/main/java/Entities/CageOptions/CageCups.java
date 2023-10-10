package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_cups", schema = "production")
public class CageCups {
@Id
@Column(name = "cups_id")
private int cupsId;
@Column(name = "cups")
private String cups;


}
