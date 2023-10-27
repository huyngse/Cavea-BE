package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entities.RegularCage;
import com.example.demo.Repo.CageRepository;
import com.example.demo.Repo.RegularCageImageRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.RegularCageImage;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@RestController
@RequestMapping("/cages")
@CrossOrigin("http://localhost:3000")
public class CageController {
    public static String extractPublicIdFromUrl(String imageUrl) {
        int lastSlashIndex = imageUrl.lastIndexOf("/");
        int dotIndex = imageUrl.lastIndexOf(".");

        if (lastSlashIndex != -1 && dotIndex != -1 && dotIndex > lastSlashIndex) {
            // Extract the part of the URL between the last '/' and the last '.'
            return imageUrl.substring(lastSlashIndex + 1, dotIndex);
        }

        // Return null if the URL doesn't match the expected format
        return null;
    }
    @Value("${cloudinary.cloud-name}")
    private String cloudinaryCloudName;

    @Value("${cloudinary.api-key}")
    private String cloudinaryApiKey;

    @Value("${cloudinary.api-secret}")
    private String cloudinaryApiSecret;

    private String saveImage(MultipartFile image) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinaryCloudName,
                "api_key", cloudinaryApiKey,
                "api_secret", cloudinaryApiSecret
        ));

        // Upload the image to Cloudinary
        Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());

        // Retrieve the image URL from the upload result
        return uploadResult.get("secure_url").toString();
    }

    private void deleteImageFromCloudinary(String imageUrl) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinaryCloudName,
                "api_key", cloudinaryApiKey,
                "api_secret", cloudinaryApiSecret
        ));

        // Extract the public ID from the image URL
        String publicId = extractPublicIdFromUrl(imageUrl);
        // Delete the image from Cloudinary
        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Autowired
    private CageRepository cageRepository;
    @Autowired
    private RegularCageImageRepository regularCageImageRepository;
    @PostMapping("/{id}/images")
    public ResponseEntity<RegularCageImage> uploadCageImage(
            @PathVariable("id") int id,
            @RequestParam("image") MultipartFile image,
            @RequestParam("isMain") boolean isMain
    ) {
        try {
            Optional<RegularCage> optionalCage = cageRepository.findById(id);
            if (optionalCage.isPresent()) {
                RegularCage cage = optionalCage.get();

                // Save image file and retrieve the URL
                String imageUrl = saveImage(image);

                // Create RegularCageImage object
                RegularCageImage cageImage = new RegularCageImage();
                cageImage.setImageUrl(imageUrl);
                cageImage.setMain(isMain);
                cageImage.setRegularCage(cage);

                // Save the RegularCageImage entity
                RegularCageImage createdImage = regularCageImageRepository.save(cageImage);

                return new ResponseEntity<>(createdImage, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            // Handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/images/{imageId}")
    public ResponseEntity<HttpStatus> deleteCageImage(@PathVariable("imageId") int imageId) {
        Optional<RegularCageImage> image = regularCageImageRepository.findById(imageId);
        if (image.isPresent()) {
            deleteImageFromCloudinary(image.get().getImageUrl());
            regularCageImageRepository.delete(image.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/images/{imageId}")
    public ResponseEntity<RegularCageImage> updateCageImage(
            @PathVariable("imageId") int imageId,
            @RequestParam("image") MultipartFile image,
            @RequestParam("isMain") boolean isMain
    ) {
        try {
            Optional<RegularCageImage> optionalCageImage = regularCageImageRepository.findById(imageId);
            if (optionalCageImage.isPresent()) {
                RegularCageImage cageImage = optionalCageImage.get();

                // Save new image file and retrieve the URL
                String newImageUrl = saveImage(image);

                // Remove the old image from Cloudinary
                deleteImageFromCloudinary(cageImage.getImageUrl());
                // Update RegularCageImage properties
                cageImage.setImageUrl(newImageUrl);
                cageImage.setMain(isMain);

                // Save the updated RegularCageImage entity
                RegularCageImage updatedImage = regularCageImageRepository.save(cageImage);

                return new ResponseEntity<>(updatedImage, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            // Handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{cageId}/images/{imageId}/main")
    public ResponseEntity<HttpStatus> setMainImage(@PathVariable("cageId") int cageId, @PathVariable("imageId") int imageId) {
        try {
            regularCageImageRepository.setMainImage(cageId, imageId);
            regularCageImageRepository.setOtherImagesAsNonMain(cageId, imageId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<RegularCage>> getAllCages() {
        List<RegularCage> cages = cageRepository.getAll();
        return new ResponseEntity<>(cages, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RegularCage> getCageById(@PathVariable("id") int id) {
        Optional<RegularCage> cage = cageRepository.findById(id);
        if (cage.isPresent()) {
            return new ResponseEntity<>(cage.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RegularCage> createCage(@RequestBody RegularCage cage) {
        RegularCage createdCage = cageRepository.save(cage);
        return new ResponseEntity<>(createdCage, HttpStatus.CREATED);
    }

    @PutMapping("/{cageId}")
    public ResponseEntity<String> updateRegularCage(@PathVariable int cageId, @RequestBody RegularCage updatedCage) {
        RegularCage existingCage = null;
        try {
            existingCage = cageRepository.findById(cageId)
                    .orElseThrow(() -> new Exception("cageRepository"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Update the properties of the existing cage with the values from the updated cage
        existingCage.setCageCode(updatedCage.getCageCode());
        existingCage.setCageName(updatedCage.getCageName());
        existingCage.setCagePrice(updatedCage.getCagePrice());
        existingCage.setDiscount(updatedCage.getDiscount());
        existingCage.setShortDescription(updatedCage.getShortDescription());
        existingCage.setLongDescription(updatedCage.getLongDescription());
        existingCage.setEnabled(updatedCage.isEnabled());
        existingCage.setQuantity(updatedCage.getQuantity());
        existingCage.setCageColor(updatedCage.getCageColor());
        // Update other properties as needed

        // Save the updated cage
        RegularCage savedCage = cageRepository.save(existingCage);

        // Return a success response
        return ResponseEntity.ok("RegularCage updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCage(@PathVariable("id") int id) {
        Optional<RegularCage> cage = cageRepository.findById(id);
        if (cage.isPresent()) {
            cageRepository.delete(cage.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<List<RegularCageImage>> getCageImages(@PathVariable("id") int id) {
        Optional<RegularCage> optionalCage = cageRepository.findById(id);
        if (optionalCage.isPresent()) {
            RegularCage cage = optionalCage.get();
            List<RegularCageImage> cageImages = regularCageImageRepository.findByRegularCage(cage);
            return new ResponseEntity<>(cageImages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<RegularCage>> searchCages(@RequestParam("cageName") String cageName) {
        List<RegularCage> foundCages = cageRepository.findByCageNameContainingIgnoreCase(cageName);
        if (!foundCages.isEmpty()) {
            return new ResponseEntity<>(foundCages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}