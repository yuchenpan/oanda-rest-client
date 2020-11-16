package com.yuchen.rest.util;

import com.yuchen.rest.model.instrument.candle.CandlestickGranularity;

public record QueryParameter(String name, String value) {
    public static QueryParameter of(String name, String value)
    {
        return new QueryParameter(name, value);
    }

    public static QueryParameter candlestickGranularity(CandlestickGranularity granularity)
    {
        return new QueryParameter("granularity", granularity.name());
    }

    public static QueryParameter count(int count)
    {
        return new QueryParameter("count", Integer.toString(count));
    }

    @Override
    public String toString() {
        return this.name + "=" + this.value;
    }
}
