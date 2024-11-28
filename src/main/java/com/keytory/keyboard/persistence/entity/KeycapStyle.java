package com.keytory.keyboard.persistence.entity;

import java.util.HashMap;
import java.util.Map;

public enum KeycapStyle {
    CHERRY("체리"),
    OEM("OEM"),
    MG("MG");

    private final String description;
    private static final Map<String, KeycapStyle> CACHE = new HashMap<>();

    static {
        for (KeycapStyle style : values()) {
            CACHE.put(style.description, style);
        }
    }

    KeycapStyle(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static KeycapStyle fromDescription(String description) {
        return CACHE.get(description);
    }
}
