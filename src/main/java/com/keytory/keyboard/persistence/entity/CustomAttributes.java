package com.keytory.keyboard.persistence.entity;

import com.keytory.keyboard.presentation.dto.CustomAttributesDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "custom_attributes")
public class CustomAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customAttibutesId;


    @ManyToOne
    @JoinColumn(name = "keytory_id")
    @NotNull
    private Keytory keytory;

    @NotNull
    private String backgroundColor;

    @NotNull
    private String legendColor;

    @Builder
    public CustomAttributes(Keytory keytory, String backgroundColor, String legendColor) {
        this.keytory = keytory;
        this.backgroundColor = backgroundColor;
        this.legendColor = legendColor;
    }

    public static CustomAttributes from(Keytory keytory, CustomAttributesDto dto) {
        return CustomAttributes.builder()
                .keytory(keytory)
                .backgroundColor(dto.backgroundColor())
                .legendColor(dto.legendColor())
                .build();
    }
}
