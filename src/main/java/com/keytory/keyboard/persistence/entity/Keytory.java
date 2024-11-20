package com.keytory.keyboard.persistence.entity;

import javax.persistence.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "keytory")
@EntityListeners(AuditingEntityListener.class)
public class Keytory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keytoryId;

    private Long userId;

    @NotBlank
    private String name;
    private String description;
    private String backgroundColor;
    private String layout;
    private String housingColor;
    private Integer housingStyleId;
    private Integer housingMaterialId;
    private String legendColor;

    @ManyToOne
    @JoinColumn(name = "switch_id")
    private Switch switchEntity;

    private Integer keycapStyleId;
    private Integer status;
    private Long viewCount;
    private Integer isDeleted;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
