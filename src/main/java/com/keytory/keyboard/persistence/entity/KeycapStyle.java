package com.keytory.keyboard.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "keycap_style")
public class KeycapStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer keycapStyleId;

    @NotBlank
    @Size(min = 1, max = 10)
    private String name;
}
