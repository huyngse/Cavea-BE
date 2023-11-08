package com.example.demo.DTO;

import java.util.Date;

public interface HistoryDTO {
    public Integer getBill_id();

    public Integer getProduct_id();

    public String getUsername();

    public Integer getStatus();

    public Date getDate_pay();

    public String getShape();

    public String getMaterial();

    public String getDescription();

    public Integer getPrice();

    public String getCreated_date();

    public String getExpected_date();

    public Integer getNumberOfSelectedItems();

    public String getCage_code();

    public String getCage_name();

    public Integer getCage_price();

    public String getShort_decription();

    public String getLong_decription();

    public Float getDiscount();

    public Integer getQuantity();

    public String getImage_url();

    public Integer getPayment_id();
}
