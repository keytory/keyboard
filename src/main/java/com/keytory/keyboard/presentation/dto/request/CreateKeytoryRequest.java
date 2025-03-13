package com.keytory.keyboard.presentation.dto.request;

import com.keytory.keyboard.presentation.dto.CustomAttributesDto;
import com.keytory.keyboard.presentation.dto.KeytoryDto;
import lombok.Builder;

import java.util.List;

public record CreateKeytoryRequest(
        KeytoryDto keytory,
        List<CustomAttributesDto> customAttributes
) {
    @Builder
    public CreateKeytoryRequest {}
}