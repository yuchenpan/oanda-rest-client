package com.yuchen.rest.net;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestSender {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    private final String apiToken;
    private final ObjectMapper mapper;

    public RequestSender(String apiToken, ObjectMapper mapper) {
        this.apiToken = apiToken;
        this.mapper = mapper;
    }

    public <T> T get(URI uri, Class<T> modelToDeserializeTo) {
        return send(HttpRequest.newBuilder(uri).GET(), modelToDeserializeTo);
    }

    public <T> T post(URI uri, HttpRequest.BodyPublisher bodyPublisher, Class<T> modelToDeserializeTo) {
        return send(HttpRequest.newBuilder(uri).POST(bodyPublisher), modelToDeserializeTo);
    }

    private <T> T send(HttpRequest.Builder requestBuilder, Class<T> modelToDeserializeTo) {
        HttpRequest request = requestBuilder
                .header("Authorization", "Bearer " + apiToken)
                .build();

        try {
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), modelToDeserializeTo);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException();
        }
    }
}
