package com.yuchen.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class URIBuilder {
    private String api;
    private String endpoint;
    private List<QueryParameter> parameters;

    private URIBuilder(String api)
    {
        this.api = api;
        this.parameters = new ArrayList<>();
    }

    public static URIBuilder api(String api)
    {
        return new URIBuilder(api);
    }

    public URIBuilder endpoint(String endpoint)
    {
        this.endpoint = endpoint;
        return this;
    }

    public URIBuilder parameter(QueryParameter parameter)
    {
        this.parameters.add(parameter);
        return this;
    }

    public URIBuilder parameters(Iterable<QueryParameter> parameters)
    {
        for (QueryParameter parameter : parameters)
        {
            this.parameters.add(parameter);
        }
        return this;
    }

    public URI build()
    {
        StringBuilder uri = new StringBuilder(api).append(endpoint);
        if (!parameters.isEmpty())
        {
            String parameterString = parameters.stream()
                    .map(Objects::toString)
                    .collect(Collectors.joining("&"));

            uri.append("?").append(parameterString);
        }
        return URI.create(uri.toString());
    }
}
