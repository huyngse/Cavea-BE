package Entities.CageOptions;

import jakarta.persistence.*;

@Entity
@Table(name = "cage_hanger", schema = "production")
public class CageHanger {
	@Id
	@Column(name = "hanger_id")
	private int hangerId;
	@Column(name = "hanger")
	private String hanger;

}
