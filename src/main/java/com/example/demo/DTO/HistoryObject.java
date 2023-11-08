package com.example.demo.DTO;

import com.example.demo.Entities.production.RegularCages;
import com.example.demo.Entities.sales.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryObject {
  private Integer billId;
  private Integer productId;
  private String username;
  private Integer status;
  private Date datePay;
  private String shape;
  private String material;
  private String description;
  private Integer price;
  private String createdDate;
  private String expectedDate;
  private Integer totalPrice;
  private Object customer;
  private Integer NumberOfSelectedItems;
  private String cage_code;
  private String cage_name;
  private Integer cage_price;
  private String short_decription;
  private String long_decription;
  private Float discount;
  private Integer quantity;
  private String image_url;
  private Payment payment;


}
