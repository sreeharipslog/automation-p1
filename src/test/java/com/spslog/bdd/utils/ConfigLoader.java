package com.spslog.bdd.utils;

import com.spslog.bdd.contants.ConfigConstants;

import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Singleton config loader
 */
public class ConfigLoader {
    private final ResourceBundle properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        this.properties = ResourceBundle.getBundle("config");
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
