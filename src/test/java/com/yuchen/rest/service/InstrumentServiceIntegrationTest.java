package com.yuchen.rest.service;

import com.yuchen.rest.IntegrationTestInstances;
import com.yuchen.rest.model.instrument.Instrument;
import com.yuchen.rest.model.instrument.candle.Candles;
import com.yuchen.rest.util.QueryParameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.yuchen.rest.model.instrument.candle.CandlestickGranularity.H1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstrumentServiceIntegrationTest {
    private InstrumentService testSubject;

    @BeforeEach
    void setUp() {
        this.testSubject = IntegrationTestInstances.instrumentService();
    }

    @Test
    void candlesWithParameters_correctInstrumentWithCorrectData() {
        Candles candles = testSubject.candles(Instrument.EURUSD,
                parameters(QueryParameter.candlestickGranularity(H1), QueryParameter.count(5)));

        assertEquals(Instrument.EURUSD, candles.instrument());
        assertEquals(H1, candles.candleStickGranularity());
        assertEquals(5, candles.candles().size());
    }

    private List<QueryParameter> parameters(QueryParameter... parameters) {
        return Arrays.asList(parameters);
    }
}