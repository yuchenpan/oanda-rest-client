package com.yuchen.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuchen.rest.model.account.AccountProperties;
import com.yuchen.rest.model.account.Accounts;
import com.yuchen.rest.model.connection.OANDAConnection;
import com.yuchen.rest.util.Endpoints;
import com.yuchen.rest.util.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * A service to access all the account endpoints offered by OANDA.
 */
public class AccountService {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    private final OANDAConnection oandaConnection;
    private final ObjectMapper jsonMapper;

    AccountService(OANDAConnection oandaConnection, ObjectMapper jsonMapper) {
        this.oandaConnection = oandaConnection;
        this.jsonMapper = jsonMapper;
    }

    /**
     * Gets a list of all accounts authorised for the current token.
     *
     * @return A list of accounts.
     */
    public List<AccountProperties> accounts() {
        URI uri = URIBuilder.api(oandaConnection.api().endpoint())
                .endpoint(Endpoints.accounts())
                .build();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header("Authorization", "Bearer " + oandaConnection.apiToken())
                .build();

        try {
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return jsonMapper.readValue(response.body(), Accounts.class).accounts();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
