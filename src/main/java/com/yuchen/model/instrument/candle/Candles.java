package com.yuchen.model.instrument.candle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuchen.model.instrument.Instrument;

import java.util.List;

public record Candles(
        @JsonProperty("instrument") Instrument instrument,
        @JsonProperty("granularity") CandlestickGranularity candleStickGranularity,
        @JsonProperty("candles") List<Candlestick> candles) {
}
