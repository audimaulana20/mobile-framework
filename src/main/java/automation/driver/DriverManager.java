package automation.driver;

import automation.config.AppConfig;
import automation.config.DeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public final class DriverManager {

    private static AndroidDriver driver;

    private DriverManager() {
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException(
                    "Driver is not initialized. Call createDriver() first."
            );
        }
        return driver;
    }

    public static void createDriver() {
        if (driver != null) {
            return;
        }
        try {
            driver = new AndroidDriver(new URL(DeviceConfig.APPIUM_URL), buildOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium URL : " + DeviceConfig.APPIUM_URL, e
            );
        }
    }

    private static UiAutomator2Options buildOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(DeviceConfig.PLATFORM_NAME);
        options.setAutomationName(DeviceConfig.AUTOMATION_NAME);
        options.setUdid(DeviceConfig.UDID);
        options.setAppPackage(AppConfig.APP_PACKAGE);
        options.setAppActivity(AppConfig.APP_ACTIVITY);
        options.setAppWaitActivity(AppConfig.APP_WAIT_ACTIVITY);
        options.setNoReset(true);
        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(Duration.ofSeconds(300));
        return options;
    }

    public static void quitDriver() {
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }

    public static boolean isDriverCreated() {
        return driver != null;
    }
}