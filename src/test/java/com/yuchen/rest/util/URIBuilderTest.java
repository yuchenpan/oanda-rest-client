package com.yuchen.rest.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class URIBuilderTest {
    private String api;
    private String endpoint;
    private List<QueryParameter> parameters;

    private URI result;

    @BeforeEach
    void setUp() {
        this.parameters = new ArrayList<>();
    }

    @Test
    void apiAndEndpoint_bothAppendedNoParameters() {
        givenAPI("api/");
        givenEndpoint("endpoint");
        whenBuilding();
        thenURIIs("api/endpoint");
    }

    @Test
    void singleParameter_parameterAdded() {
        givenAPI("api/");
        givenEndpoint("endpoint");
        givenParameters(
                parameter("key", "value")
        );
        whenBuilding();
        thenURIIs("api/endpoint?key=value");
    }

    @Test
    void multipleParameters_correctlyConcatenated() {
        givenAPI("api/");
        givenEndpoint("endpoint");
        givenParameters(
                parameter("one", "1"),
                parameter("two", "2"),
                parameter("three", "3")
        );
        whenBuilding();
        thenURIIs("api/endpoint?one=1&two=2&three=3");
    }

    private void givenAPI(String api) {
        this.api = api;
    }

    private void givenEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    private void givenParameters(QueryParameter... parameters) {
        this.parameters.addAll(Arrays.asList(parameters));
    }

    private QueryParameter parameter(String key, String value) {
        return QueryParameter.of(key, value);
    }

    private void whenBuilding() {
        result = URIBuilder.api(api)
                .endpoint(endpoint)
                .parameters(parameters)
                .build();
    }

    private void thenURIIs(String expected) {
        assertEquals(expected, result.toString());
    }
}