package automation.base;

import io.appium.java_client.AppiumDriver;

public abstract class BasePage<L extends BaseLocator> {

    protected final AppiumDriver driver;
    protected final Element element;
    protected L mLocator;

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.element = new Element(driver);
        setupLocator();
    }

    protected abstract void setupLocator();
}
