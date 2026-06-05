package automation.base;

public abstract class BaseLocator {

    protected Locator id(String value) {
        return new Locator(LocatorType.ID, value);
    }

    protected Locator xpath(String value) {
        return new Locator(LocatorType.XPATH, value);
    }

    protected Locator accessibilityId(String value) {
        return new Locator(LocatorType.ACCESSIBILITY_ID, value);
    }

    protected Locator uiAutomator(String value) {
        return new Locator(LocatorType.UIAUTOMATOR, value);
    }
}