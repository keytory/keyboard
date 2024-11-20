package com.keytory.keyboard.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String name;
}