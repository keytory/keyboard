package com.keytory.keyboard.persistence.entity;

import java.util.HashMap;
import java.util.Map;

public enum HousingMaterial {
    MATTE("매트"),
    BRUSHED("브러쉬"),
    GLOSSY("광택");

    private final String description;
    private static final Map<String, HousingMaterial> CACHE = new HashMap<>();

    static {
        for (HousingMaterial material : values()) {
            CACHE.put(material.description, material);
        }
    }

    HousingMaterial(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static HousingMaterial fromDescription(String description) {
        return CACHE.get(description);
    }
}
