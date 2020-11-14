package com.yuchen.model.instrument.candle;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public record Candlestick(
        @JsonProperty("complete") boolean complete,
        @JsonProperty("volume") int volume,
        @JsonProperty("time") DateTime time,
        @JsonProperty("mid") CandlestickData candlestickData) {
}
