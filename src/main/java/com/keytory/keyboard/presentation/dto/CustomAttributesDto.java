package com.keytory.keyboard.presentation.dto;

import com.keytory.keyboard.persistence.entity.CustomAttributes;
import lombok.Builder;

@Builder
public record CustomAttributesDto(
        String backgroundColor,
        String legendColor
) {
    public static CustomAttributesDto from(CustomAttributes customAttributes) {
        return CustomAttributesDto.builder()
                .backgroundColor(customAttributes.getBackgroundColor())
                .legendColor(customAttributes.getLegendColor())
                .build();
    }
}
