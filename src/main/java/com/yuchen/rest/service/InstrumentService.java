package com.yuchen.rest.service;

import com.yuchen.rest.model.instrument.Instrument;
import com.yuchen.rest.model.instrument.candle.Candles;
import com.yuchen.rest.net.RequestSender;
import com.yuchen.rest.util.Endpoints;
import com.yuchen.rest.util.QueryParameter;
import com.yuchen.rest.util.URIBuilder;

import java.net.URI;
import java.util.List;

/**
 * A service to access all the instrument endpoints offered by OANDA.
 */
public class InstrumentService {
    private final String api;
    private final RequestSender requestSender;

    InstrumentService(String api, RequestSender requestSender) {
        this.api = api;
        this.requestSender = requestSender;
    }

    /**
     * Gets candlestick data for an instrument.
     *
     * @param instrument The instrument to get candlestick data for.
     * @param parameters Parameters for the query. For example the timeframe the candles are in and the number of
     *                   candles to get.
     * @return Candlestick data for given instrument and parameters.
     */
    public Candles candles(Instrument instrument, List<QueryParameter> parameters) {
        URI uri = URIBuilder.api(api)
                .endpoint(Endpoints.candles(instrument))
                .parameters(parameters)
                .build();

        return requestSender.get(uri, Candles.class);
    }
}
