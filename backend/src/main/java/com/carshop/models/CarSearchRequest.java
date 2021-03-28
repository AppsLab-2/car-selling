package com.carshop.models;

import com.carshop.entities.Brand;
import com.carshop.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarSearchRequest {

    private Brand brands;

    private Model model;

    private Double minPrice;

    private Double maxPrice;

    private Integer minRegistrationYear;

    private Integer maxRegistrationYear;

    private Integer minHp;

    private Integer maxHp;

    private String fuel;

    private String type;

    private String transmission;

}
