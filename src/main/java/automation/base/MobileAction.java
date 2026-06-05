package automation.base;

public interface MobileAction {

    void tap(Locator locator);

    void type(Locator locator, String text);

    void clear(Locator locator);

    String getText(Locator locator);

    boolean isDisplayed(Locator locator);

    boolean isEnabled(Locator locator);

    void waitVisible(Locator locator);

    void waitClickable(Locator locator);

    void waitGone(Locator locator);

    void swipeUp();

    void swipeDown();

    void swipeLeft();

    void swipeRight();

    void longPress(Locator locator);

    void dragAndDrop(Locator source, Locator target);

    void scrollToText(String text);

    void takeScreenshot(String fileName);
}
