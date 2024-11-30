package com.keytory.keyboard.presentation.dto;

import com.keytory.keyboard.persistence.entity.*;
import lombok.Builder;

@Builder
public record KeytoryDto (String name,
                          String description,
                          String backgroundColor,
                          String housingColor,
                          String legendColor,
                          Layout layout,
                          HousingStyle housingStyle,
                          HousingMaterial housingMaterial,
                          KeycapStyle keycapStyle){

    public static KeytoryDto from(Keytory keytory) {
        return KeytoryDto.builder()
                .name(keytory.getName())
                .description(keytory.getDescription())
                .backgroundColor(keytory.getBackgroundColor())
                .housingColor(keytory.getHousingColor())
                .legendColor(keytory.getLegendColor())
                .layout(keytory.getLayout())
                .housingStyle(keytory.getHousingStyle())
                .housingMaterial(keytory.getHousingMaterial())
                .keycapStyle(keytory.getKeycapStyle())
                .build();
    }
}
