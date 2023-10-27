package com.example.demo.Repo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entities.RegularCageImage;
import com.example.demo.Entities.RegularCage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface RegularCageImageRepository extends JpaRepository<RegularCageImage, Integer> {
    List<RegularCageImage> findByRegularCage(RegularCage regularCage);
    @Modifying
    @Transactional
    @Query(value = "UPDATE production.regular_cage_images SET is_main = 1 WHERE cage_id = :cageId AND image_id = :imageId", nativeQuery = true)
    void setMainImage(@Param("cageId") Integer cageId, @Param("imageId") Integer imageId);
    @Modifying
    @Transactional
    @Query(value = "UPDATE production.regular_cage_images SET is_main = 0 " +
            "WHERE cage_id = :cageId AND image_id <> :mainImageId",
    nativeQuery = true)
    void setOtherImagesAsNonMain(@Param("cageId") int cageId, @Param("mainImageId") int mainImageId);
}