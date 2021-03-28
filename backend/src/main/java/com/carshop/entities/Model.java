package com.carshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Model {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Model(String name) {
        this.name = name;
    }
}
