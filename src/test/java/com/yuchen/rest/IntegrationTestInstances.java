package com.yuchen.rest;

import com.yuchen.rest.model.connection.API;
import com.yuchen.rest.model.connection.OANDAConnection;
import com.yuchen.rest.service.AccountService;
import com.yuchen.rest.service.InstrumentService;
import com.yuchen.rest.service.ServiceFactory;

public class IntegrationTestInstances {
    private static final ServiceFactory SERVICE_FACTORY = serviceFactory();

    private static ServiceFactory serviceFactory() {
        return new ServiceFactory(new OANDAConnection(API.PRACTICE, IntegrationTestProperties.API_TOKEN));
    }

    public static InstrumentService instrumentService() {
        return SERVICE_FACTORY.instrumentService();
    }

    public static AccountService accountService() {
        return SERVICE_FACTORY.accountService();
    }
}
