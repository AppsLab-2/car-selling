package com.carshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Model model;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int productionYear;

    private int hp;

    private String fuel;

    private String transmission;

    private String type;

    private double price;

    private String image;

}
