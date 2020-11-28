package com.yuchen.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.yuchen.rest.model.connection.OANDAConnection;
import com.yuchen.rest.net.RequestSender;

public class ServiceFactory {
    private final OANDAConnection oandaConnection;

    public ServiceFactory(OANDAConnection oandaConnection) {
        this.oandaConnection = oandaConnection;
    }

    public InstrumentService instrumentService() {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule());
        RequestSender requestSender = new RequestSender(oandaConnection.apiToken(), mapper);
        return new InstrumentService(oandaConnection.api().endpoint(), requestSender);
    }

    public AccountService accountService() {
        RequestSender requestSender = new RequestSender(oandaConnection.apiToken(), new ObjectMapper());
        return new AccountService(oandaConnection.api().endpoint(), requestSender);
    }
}
