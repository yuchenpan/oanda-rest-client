package com.yuchen.rest.service;

import com.yuchen.rest.model.account.AccountProperties;
import com.yuchen.rest.model.account.Accounts;
import com.yuchen.rest.net.RequestSender;
import com.yuchen.rest.util.Endpoints;
import com.yuchen.rest.util.URIBuilder;

import java.net.URI;
import java.util.List;

/**
 * A service to access all the account endpoints offered by OANDA.
 */
public class AccountService {
    private final String api;
    private final RequestSender requestSender;

    AccountService(String api, RequestSender requestSender) {
        this.api = api;
        this.requestSender = requestSender;
    }

    /**
     * Gets a list of all accounts authorised for the current token.
     *
     * @return A list of accounts.
     */
    public List<AccountProperties> accounts() {
        URI uri = URIBuilder.api(api)
                .endpoint(Endpoints.accounts())
                .build();

        return requestSender.get(uri, Accounts.class)
                .accounts();
    }
}
