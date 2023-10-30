package com.example.demo.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Service
public class CloudinaryService {
    @Value("${cloudinary.cloud-name}")
    private String cloudinaryCloudName;

    @Value("${cloudinary.api-key}")
    private String cloudinaryApiKey;

    @Value("${cloudinary.api-secret}")
    private String cloudinaryApiSecret;
    public String saveImage(MultipartFile image) throws IOException {
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

    public void deleteImageFromCloudinary(String imageUrl) {
        System.out.println(cloudinaryCloudName);
        System.out.println(cloudinaryApiKey);
        System.out.println(cloudinaryApiSecret);
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
}
