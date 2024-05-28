package com.lab3.lab3eng.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Toys extends Product {
    private String toyType;

    public Toys(String title, String description, int qty, float price, String manufacturer, String toyType) {
        super(title, description, qty, price, manufacturer);
        this.toyType = toyType;
    }


}
