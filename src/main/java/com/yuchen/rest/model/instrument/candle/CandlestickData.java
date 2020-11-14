package com.yuchen.rest.model.instrument.candle;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CandlestickData(
        @JsonProperty("o") String open,
        @JsonProperty("h") String high,
        @JsonProperty("l") String low,
        @JsonProperty("c") String close) {
}
