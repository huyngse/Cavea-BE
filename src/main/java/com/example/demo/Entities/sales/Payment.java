package com.example.demo.Entities.sales;

import com.example.demo.Entities.dbo.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "payment", schema = "sales")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Column(name = "method")
    private String method;
    @OneToMany(mappedBy = "payment")
    @ToString.Exclude
    @JsonIgnore
    private List<Cart> carts;
}