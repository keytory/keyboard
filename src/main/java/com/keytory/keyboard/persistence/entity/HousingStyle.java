package com.keytory.keyboard.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "housing_style")
public class HousingStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer housingStyleId;

    @NotBlank
    @Size(min = 1, max = 10)
    private String name;
}