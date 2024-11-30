package com.keytory.keyboard.application.keytory;

import com.keytory.keyboard.common.exception.ErrorCode;
import com.keytory.keyboard.common.exception.NotFoundException;
import com.keytory.keyboard.persistence.entity.CustomAttributes;
import com.keytory.keyboard.persistence.entity.Keytory;
import com.keytory.keyboard.persistence.repository.CustomAttributesRepository;
import com.keytory.keyboard.persistence.repository.KeytoryRepository;
import com.keytory.keyboard.presentation.dto.CustomAttributesDto;
import com.keytory.keyboard.presentation.dto.KeytoryDto;
import com.keytory.keyboard.presentation.dto.request.CreateKeytoryRequest;
import com.keytory.keyboard.presentation.dto.response.CreateKeytoryResponse;
import com.keytory.keyboard.presentation.dto.response.GetAllKeytoryResponse;
import com.keytory.keyboard.presentation.dto.response.GetKeytoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class KeytoryService {

    private final KeytoryRepository keytoryRepository;
    private final CustomAttributesRepository customAttributesRepository;
    private final ViewTrackingService viewTrackingService;

    public CreateKeytoryResponse createKeytory(CreateKeytoryRequest request, Long userId) {
        Keytory keytory = Keytory.from(request, userId);
        Keytory saved = keytoryRepository.save(keytory);

        if (request.customAttributes() != null) {
            List<CustomAttributes> customAttributes = request.customAttributes().stream()
                    .map(attr -> CustomAttributes.from(saved, attr))
                    .toList();
            customAttributesRepository.saveAll(customAttributes);
        }

        return CreateKeytoryResponse.from(keytory);
    }

    @Transactional(readOnly = true)
    public GetKeytoryResponse getKeytoryByKeytoryId(Long keytoryId) {
        Keytory keytory = keytoryRepository.findById(keytoryId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_KEYTORY));

        List<CustomAttributesDto> customAttributes = customAttributesRepository.findById(keytoryId).stream()
                .map(CustomAttributesDto::from)
                .toList();

        return GetKeytoryResponse.builder()
                .keytory(KeytoryDto.from(keytory))
                .customAttributes(customAttributes)
                .build();
    }

    @Transactional(readOnly = true)
    public GetAllKeytoryResponse getKeytoriesByUserId(Long userId) {
        List<GetKeytoryResponse> keytories = keytoryRepository.findAllByUserId(userId).stream()
                .map(keytory -> getKeytoryByKeytoryId(keytory.getKeytoryId()))
                .toList();

        return GetAllKeytoryResponse.builder()
                .keytories(keytories)
                .build();
    }

    @Transactional
    public void deleteKeytory(Long keytoryId) {
        Keytory keytory = keytoryRepository.findById(keytoryId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_KEYTORY));
        keytory.delete();
    }

    public GetKeytoryResponse getKeytoryWithViewIncrement(Long keytoryId, String userIp) {
        Keytory keytory = keytoryRepository.findById(keytoryId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_KEYTORY));

        if (viewTrackingService.shouldIncrementView(keytoryId, userIp)) {
            keytory.view();
            keytoryRepository.save(keytory);
        }

        List<CustomAttributesDto> customAttributes = customAttributesRepository.findById(keytoryId).stream()
                .map(CustomAttributesDto::from)
                .toList();

        return GetKeytoryResponse.builder()
                .keytory(KeytoryDto.from(keytory))
                .customAttributes(customAttributes)
                .build();
    }
}
