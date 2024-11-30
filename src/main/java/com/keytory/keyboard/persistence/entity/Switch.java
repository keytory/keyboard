package com.keytory.keyboard.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "switches")
public class Switch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer switchId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "switchType_Id")
    private SwitchType switchType;

    @NotBlank
    @Size(min = 1, max = 255)
    private String name;

    @Size(max = 255)
    private String sound;

}
