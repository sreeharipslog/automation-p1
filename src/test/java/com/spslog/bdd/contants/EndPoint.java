package com.spslog.bdd.contants;

public enum EndPoint {
    STORE("/store"),
    ABOUT("/about");

    public final String path;

    EndPoint(String urlPath) {
        this.path = urlPath;
    }
}
