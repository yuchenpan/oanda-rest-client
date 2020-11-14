package com.yuchen.util;

import com.yuchen.model.instrument.Instrument;

public class Endpoints {
    private static final String CANDLES_ENDPOINT = "v3/instruments/%s/candles";

    public static String candles(Instrument instrument)
    {
        return String.format(CANDLES_ENDPOINT, instrument.string());
    }
}
