package com.keytory.keyboard.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "switch_type")
public class SwitchType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer switchTypeId;

    @Size(max = 255)
    private String name;
}