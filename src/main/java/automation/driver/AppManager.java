package automation.driver;

import automation.config.AppConfig;
import io.appium.java_client.android.AndroidDriver;

public final class AppManager {

    private AppManager() {}
    private static AndroidDriver driver() {
        return DriverManager.getDriver();
    }

    public static boolean isInstalled() {
        return driver().isAppInstalled(AppConfig.APP_PACKAGE
        );
    }

    public static void launchApp() {
        driver().activateApp(AppConfig.APP_PACKAGE
        );
    }

    public static void terminateApp() {
        driver().terminateApp(AppConfig.APP_PACKAGE
        );
    }

    public static void relaunchApp() {
        terminateApp();
        launchApp();
    }
}