package com.example.demo.DTO;

import com.example.demo.Entities.production.RegularCages;
import com.example.demo.Entities.sales.CustomCageOrders;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDTO {
    private Integer billId;
    private Integer productId;
    private String username;
    private Integer status;
    private Date datePay;
    private String shape;
    private String material;
    private String description;
    private String birdtypeId;
    private Integer price;

    private String createdDate;
    private String expectedDate;
    private RegularCages regularCages;
    private CustomCageOrders cageOrders;
    private Integer NumberOfSelectedItems;


}
