package com.yuchen.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IntegrationTestProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTestProperties.class);
    private static final String PROPERTIES_FILE = "test-secrets.properties";
    private static final Properties properties = loadProperties();

    public static final String API_TOKEN = properties.getProperty("TEST_API_TOKEN");

    public static Properties loadProperties()
    {
        InputStream in = IntegrationTestProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);

        Properties props = new Properties();

        if (in != null) {
            try {
                props.load(in);
            } catch (IOException e) {
                LOGGER.error("Couldn't load test properties!", e);
            }
        }

        return props;
    }
}
