package com.yuchen.rest.model.instrument;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Instrument {
    EURUSD("EUR_USD");

    private final String name;

    Instrument(String name)
    {
        this.name = name;
    }

    @JsonValue
    public String string() {
        return this.name;
    }
}
