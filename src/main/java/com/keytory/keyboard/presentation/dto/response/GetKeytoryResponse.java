package com.keytory.keyboard.presentation.dto.response;

import com.keytory.keyboard.presentation.dto.CustomAttributesDto;
import com.keytory.keyboard.presentation.dto.KeytoryDto;
import lombok.Builder;

import java.util.List;

@Builder
public record GetKeytoryResponse(KeytoryDto keytory,
                                 List<CustomAttributesDto> customAttributes) {
}
