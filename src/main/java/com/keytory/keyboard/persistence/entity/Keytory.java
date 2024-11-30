package com.keytory.keyboard.persistence.entity;

import com.keytory.keyboard.presentation.dto.request.CreateKeytoryRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Table(name = "keytory")
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keytory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keytoryId;

    private Long userId;

    @NotBlank
    private String name;
    private String description;
    private String backgroundColor;

    @Enumerated(EnumType.STRING)
    private Layout layout;
    private String housingColor;

    @Enumerated(EnumType.STRING)
    private HousingStyle housingStyle;

    @Enumerated(EnumType.STRING)
    private HousingMaterial housingMaterial;

    private String legendColor;

    @ManyToOne
    @JoinColumn(name = "switch_id")
    private Switch switchEntity;

    @Enumerated(EnumType.STRING)
    private KeycapStyle keycapStyle;

    private Integer status;
    private Long viewCount = 0L;

    private Integer isDeleted = 0;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


    public void delete() {
        this.isDeleted = 1;
    }

    @Builder
    public Keytory(Long userId, String name, String description, String backgroundColor, Layout layout,
                   String housingColor, HousingStyle housingStyle, HousingMaterial housingMaterial,
                   String legendColor, Switch switchEntity, KeycapStyle keycapStyle, Integer status,
                   Long viewCount, Integer isDeleted) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.layout = layout;
        this.housingColor = housingColor;
        this.housingStyle = housingStyle;
        this.housingMaterial = housingMaterial;
        this.legendColor = legendColor;
        this.switchEntity = switchEntity;
        this.keycapStyle = keycapStyle;
        this.status = status;
        this.viewCount = viewCount;
        this.isDeleted = isDeleted;
    }


    public static Keytory from(CreateKeytoryRequest request, Long userId) {
        return Keytory.builder()
                .userId(userId)
                .name(request.keytory().name())
                .description(request.keytory().description())
                .backgroundColor(request.keytory().backgroundColor())
                .layout(request.keytory().layout())
                .housingColor(request.keytory().housingColor())
                .housingStyle(request.keytory().housingStyle())
                .housingMaterial(request.keytory().housingMaterial())
                .legendColor(request.keytory().legendColor())
                .keycapStyle(request.keytory().keycapStyle())
                .status(0)
                .viewCount(0L)
                .isDeleted(0)
                .build();
    }

    public void view() {
        this.viewCount++;
    }
}
