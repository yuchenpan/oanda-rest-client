package com.yuchen.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.yuchen.model.instrument.Instrument;
import com.yuchen.model.instrument.candle.Candles;
import com.yuchen.model.instrument.connection.OANDAConnection;
import com.yuchen.util.Endpoints;
import com.yuchen.util.QueryParameter;
import com.yuchen.util.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class InstrumentService {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    private final OANDAConnection oandaConnection;
    private final ObjectMapper objectMapper;

    public InstrumentService(OANDAConnection oandaConnection)
    {
        this.oandaConnection = oandaConnection;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JodaModule());
    }

    public Candles candles(Instrument instrument, List<QueryParameter> parameters) {
        URI uri = URIBuilder.api(oandaConnection.api().endpoint())
                .endpoint(Endpoints.candles(instrument))
                .parameters(parameters)
                .build();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header("Authorization", "Bearer " + oandaConnection.apiToken())
                .build();

        try {
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), Candles.class);
        } catch (InterruptedException | IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
