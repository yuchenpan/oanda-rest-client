package com.yuchen.rest.util;

import com.yuchen.rest.model.instrument.Instrument;

public class Endpoints {
    private static final String CANDLES_ENDPOINT = "v3/instruments/%s/candles";

    public static String candles(Instrument instrument)
    {
        return String.format(CANDLES_ENDPOINT, instrument.string());
    }
}
