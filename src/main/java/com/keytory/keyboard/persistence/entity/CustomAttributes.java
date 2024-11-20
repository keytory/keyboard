package com.keytory.keyboard.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "custom_attributes")
public class CustomAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    @NotNull
    private Long keytoryId;

    @NotNull
    private String backgroundColor;

    @NotNull
    private String legendColor;
}
