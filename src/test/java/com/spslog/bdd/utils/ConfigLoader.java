package com.spslog.bdd.utils;

import com.spslog.bdd.contants.ConfigConstants;
import com.spslog.bdd.contants.EnvType;

import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Singleton config loader
 */
public class ConfigLoader {
    private static ConfigLoader configLoader;
    private final ResourceBundle properties;

    private ConfigLoader() {
        String env = System.getProperty("env", EnvType.DEV.toString()).toUpperCase();
        switch (EnvType.valueOf(env)) {
            case DEV -> this.properties = ResourceBundle.getBundle("dev-config");
            case PROD -> this.properties = ResourceBundle.getBundle("prod-config");
            default -> throw new IllegalArgumentException("Environment provided is not valid");
        }
    }

    public static ConfigLoader getInstance() {
        if (Objects.isNull(configLoader)) configLoader = new ConfigLoader();
        return configLoader;
    }

    // Configuration accessor methods

    public String getBaseUrl() {
        return properties.getString(ConfigConstants.BASE_URL);
    }
}
