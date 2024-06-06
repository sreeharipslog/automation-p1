package com.spslog.bdd.contants;

import static com.spslog.bdd.contants.AppConstants.EMPTY;
import static com.spslog.bdd.contants.ConfigConstants.*;

public enum Browser {
    CHROME(CHROME_PATH, CHROME_DRIVER_PATH),
    HEADLESS_CHROME(CHROME_PATH, CHROME_DRIVER_PATH),
    FIREFOX(EMPTY, FIREFOX_DRIVER_PATH),
    EDGE(EMPTY, EMPTY);

    public final String path, driverPath;

    Browser(String path, String driverPath) {
        this.path = path;
        this.driverPath = driverPath;
    }
}
