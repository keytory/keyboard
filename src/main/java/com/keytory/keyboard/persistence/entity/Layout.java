package com.keytory.keyboard.persistence.entity;

import java.util.HashMap;
import java.util.Map;

public enum Layout {
    _75("75%"),
    _80("80%"),
    _100("100%");

    private final String description;
    private static final Map<String, Layout> CACHE = new HashMap<>();

    static {
        for (Layout layout : values()) {
            CACHE.put(layout.description, layout);
        }
    }

    Layout(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Layout fromDescription(String description) {
        return CACHE.get(description);
    }
}
