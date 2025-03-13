package com.keytory.keyboard.presentation.controller;

import com.keytory.keyboard.application.keytory.KeytoryService;
import com.keytory.keyboard.presentation.dto.response.CreateKeytoryResponse;
import com.keytory.keyboard.presentation.dto.request.CreateKeytoryRequest;
import com.keytory.keyboard.presentation.dto.response.GetAllKeytoryResponse;
import com.keytory.keyboard.presentation.dto.response.GetKeytoryResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keytories")
@RequiredArgsConstructor
public class KeytoryController {

    private final KeytoryService keytoryService;

    @PostMapping
    public ResponseEntity<CreateKeytoryResponse> createKeytoryWithCustomAttributes(@RequestBody CreateKeytoryRequest request,
                                                                                   @RequestParam Long userId) {
        return ResponseEntity.ok(keytoryService.createKeytory(request, userId));
    }

    @GetMapping("/{keytory-id}")
    public ResponseEntity<GetKeytoryResponse> getKeytory(@PathVariable("keytory-id") Long keytoryId,
                                                         HttpServletRequest request) {
        String userIp = request.getRemoteAddr();
        return ResponseEntity.ok(keytoryService.getKeytoryWithViewIncrement(keytoryId, userIp));
    }

    @GetMapping
    public ResponseEntity<GetAllKeytoryResponse> getAllKeytory(@RequestParam Long userId) {
        return ResponseEntity.ok(keytoryService.getKeytoriesByUserId(userId));
    }

    @DeleteMapping("/{keytory-id}")
    public ResponseEntity<Void> deleteKeytory(@PathVariable("keytory-id") Long keytoryId) {
        keytoryService.deleteKeytory(keytoryId);
        return ResponseEntity.noContent().build();
    }
}
