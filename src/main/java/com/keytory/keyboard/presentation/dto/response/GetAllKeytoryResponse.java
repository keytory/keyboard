package com.keytory.keyboard.presentation.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record GetAllKeytoryResponse(List<GetKeytoryResponse> keytories) {
}
