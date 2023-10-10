package Entities;

import jakarta.persistence.*;
@Entity
@Table(name ="regular_cage_images")
public class CageImages {
@Id
@GeneratedValue(strategy = GenarationType.IDENTITY)
@Column(name = "image_id")
private String imageId;
@Column(name = "iamge_url")
private String imageURL;
@Column(name = "cage_id")
private int cageId;
@Column(name ="is_main")
private boolean isMain;
}
