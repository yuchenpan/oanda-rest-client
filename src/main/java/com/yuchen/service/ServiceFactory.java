package com.yuchen.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.yuchen.model.connection.OANDAConnection;

public class ServiceFactory {
    private final OANDAConnection oandaConnection;

    public ServiceFactory(OANDAConnection oandaConnection)
    {
        this.oandaConnection = oandaConnection;
    }

    public InstrumentService instrumentService()
    {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule());
        return new InstrumentService(oandaConnection, mapper);
    }
}
