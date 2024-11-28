package com.keytory.keyboard.persistence.entity;

import java.util.HashMap;
import java.util.Map;

public enum HousingStyle {
    ROUNDED("둥근"),
    ANGULAR("각진");

    private final String description;
    private static final Map<String, HousingStyle> CACHE = new HashMap<>();

    static {
        for (HousingStyle style : values()) {
            CACHE.put(style.description, style);
        }
    }

    HousingStyle(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static HousingStyle fromDescription(String description) {
        return CACHE.get(description);
    }
}
