package com.example.demo.Entities;

import jakarta.persistence.*;


@Entity
@Table(name = "regular_cage_images", schema = "production")
public class CageImages {
	@Id
	@Column(name = "image_id")
	private int imageId;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "cage_id")
	private int cageId;
	@Column(name = "is_main")
	private boolean isMain;
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCageId() {
		return cageId;
	}
	public void setCageId(int cageId) {
		this.cageId = cageId;
	}
	public boolean isMain() {
		return isMain;
	}
	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}
}
