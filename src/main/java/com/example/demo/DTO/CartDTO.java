package com.example.demo.DTO;

import com.example.demo.Entities.production.RegularCages;
import com.example.demo.Entities.sales.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private Integer id;
    private Integer customCage_id;
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
    private String email;
    private String full_name;
    private String address;
    private Integer totalPrice;
    private String phone;
}
