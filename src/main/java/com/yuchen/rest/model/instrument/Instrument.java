package com.yuchen.rest.model.instrument;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Instrument {
    EURUSD("EUR_USD"),
    USDJPY("USD_JPY"),
    GBPUSD("GBP_USD"),
    USDCHF("USD_CHF"),
    USDCAD("USD_CAD"),
    AUDUSD("AUD_USD"),
    NZDUSD("NZD_USD");

    private final String name;

    Instrument(String name) {
        this.name = name;
    }

    @JsonValue
    public String string() {
        return this.name;
    }
}
