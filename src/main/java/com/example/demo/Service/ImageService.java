package com.example.demo.Service;

import com.example.demo.Entities.RegularCageImage;
import com.example.demo.Repo.RegularCageImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ImageService {
    @Autowired
    private RegularCageImageRepository regularCageImageRepository;

    public void setMainImage(int cageId, int imageId) {
        Optional<RegularCageImage> optionalImage = regularCageImageRepository.findById(imageId);
        if (optionalImage.isPresent()) {
            RegularCageImage image = optionalImage.get();
            image.setMain(true);
            regularCageImageRepository.save(image);

            // Set other images as non-main if needed
            if (image.isMain()) {
                regularCageImageRepository.setOtherImagesAsNonMain(image.getCageId(), imageId);
            }
        } else {
            try {
                throw new Exception("Image not found with ID: " + imageId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
