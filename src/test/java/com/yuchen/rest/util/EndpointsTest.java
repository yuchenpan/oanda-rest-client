package com.yuchen.rest.util;

import com.yuchen.rest.model.instrument.Instrument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EndpointsTest {

    @Test
    void candles_instrumentEndpointCorrect()
    {
        assertEquals("v3/instruments/EUR_USD/candles", Endpoints.candles(Instrument.EURUSD));
    }
}