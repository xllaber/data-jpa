package com.llacerximo.spring.datajpa.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "invoice_lines")
public class InvoiceLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getLinePrice() {
        return amount.doubleValue() * product.getPrice();
    }
}
