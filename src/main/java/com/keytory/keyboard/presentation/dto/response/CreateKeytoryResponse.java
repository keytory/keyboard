package com.keytory.keyboard.presentation.dto.response;

import com.keytory.keyboard.persistence.entity.Keytory;
import lombok.Builder;

@Builder
public record CreateKeytoryResponse(Long keytoryId) {
    public static CreateKeytoryResponse from(Keytory keytory) {
        return CreateKeytoryResponse.builder()
                .keytoryId(keytory.getKeytoryId())
                .build();
    }

}