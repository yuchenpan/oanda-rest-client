package com.yuchen.rest.model.connection;

public enum API {
    TRADE("https://api-fxtrade.oanda.com/"),
    PRACTICE("https://api-fxpractice.oanda.com/"),
    STREAM_TRADE("https://stream-fxtrade.oanda.com/"),
    STREAM_PRACTICE("https://stream-fxpractice.oanda.com/");

    private final String endpoint;

    API(String endpoint)
    {
        this.endpoint = endpoint;
    }

    public String endpoint()
    {
        return this.endpoint;
    }
}
