package com.example.demo.DTO;

import com.example.demo.Entities.production.RegularCages;
import java.util.Date;

public interface CartDTOInterface {

    public Integer getBill_id();

    public Integer getProduct_id();

//    public Integer getCustom_product_id();

    public String getUsername();

    public Integer getStatus();

    public Date getDate_pay();

    public String getShape();

    public String getMaterial();

    public String getDescription();

    public String getBirdtypeId();

    public Integer getPrice();

    public String getCreated_date();

    public String getExpected_date();

    public Integer getNumberOfSelectedItems();

}
