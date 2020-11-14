package com.yuchen.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuchen.rest.model.connection.OANDAConnection;
import com.yuchen.rest.model.instrument.Instrument;
import com.yuchen.rest.model.instrument.candle.Candles;
import com.yuchen.rest.util.Endpoints;
import com.yuchen.rest.util.QueryParameter;
import com.yuchen.rest.util.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class InstrumentService {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    private final OANDAConnection oandaConnection;
    private final ObjectMapper jsonMapper;

    InstrumentService(OANDAConnection oandaConnection, ObjectMapper jsonMapper)
    {
        this.oandaConnection = oandaConnection;
        this.jsonMapper = jsonMapper;
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
            return jsonMapper.readValue(response.body(), Candles.class);
        } catch (InterruptedException | IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
