package com.yuchen.rest;

import com.yuchen.rest.model.connection.API;
import com.yuchen.rest.model.connection.OANDAConnection;
import com.yuchen.rest.service.AccountService;
import com.yuchen.rest.service.InstrumentService;
import com.yuchen.rest.service.ServiceFactory;

public class IntegrationTestInstances {
    private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
    private static final OANDAConnection CONNECTION = new OANDAConnection(API.PRACTICE, IntegrationTestProperties.API_TOKEN);

    public static InstrumentService instrumentService() {
        return SERVICE_FACTORY.instrumentService(CONNECTION);
    }

    public static AccountService accountService() {
        return SERVICE_FACTORY.accountService(CONNECTION);
    }
}
