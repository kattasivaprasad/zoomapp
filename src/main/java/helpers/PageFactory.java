package helpers;

import io.appium.java_client.AppiumDriver;

public class PageFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void setDriver(AppiumDriver driverInstance) {
        driver = driverInstance;
    }
}
