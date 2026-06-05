package automation.base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Collections;

public class Element implements MobileAction {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);
    private final AppiumDriver driver;

    public Element(AppiumDriver driver) {
        this.driver = driver;
    }

    private By resolve(Locator locator) {
        return switch (locator.type()) {
            case ID -> By.id(locator.value());
            case XPATH -> By.xpath(locator.value());
            case ACCESSIBILITY_ID -> AppiumBy.accessibilityId(locator.value());
            case UIAUTOMATOR -> AppiumBy.androidUIAutomator(locator.value());
        };
    }

    private WebDriverWait waitDriver() {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    private WebElement waitUntilVisible(Locator locator) {
        return waitDriver().until(ExpectedConditions.visibilityOfElementLocated(resolve(locator)));
    }

    private WebElement waitUntilClickable(Locator locator) {
        return waitDriver().until(
                ExpectedConditions.elementToBeClickable(resolve(locator)));
    }

    @Override
    public void tap(Locator locator) {
        waitUntilClickable(locator).click();
    }

    @Override
    public void type(Locator locator, String text) {
        WebElement element = waitUntilVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    @Override
    public void clear(Locator locator) {
        waitUntilVisible(locator).clear();
    }

    @Override
    public String getText(Locator locator) {
        return waitUntilVisible(locator).getText();
    }

    @Override
    public boolean isDisplayed(Locator locator) {
        try {
            return waitUntilVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isEnabled(Locator locator) {
        try {
            return waitUntilVisible(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void waitVisible(Locator locator) {
        waitUntilVisible(locator);
    }

    @Override
    public void waitClickable(Locator locator) {
        waitUntilClickable(locator);
    }

    @Override
    public void waitGone(Locator locator) {
        waitDriver().until(
                ExpectedConditions.invisibilityOfElementLocated(
                        resolve(locator)
                )
        );
    }

    @Override
    public void swipeUp() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        int startX = width / 2;
        int startY = (int) (height * 0.8);
        int endY = (int) (height * 0.2);
        swipe(startX, startY, startX, endY);
    }

    @Override
    public void swipeDown() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        int startX = width / 2;
        int startY = (int) (height * 0.2);
        int endY = (int) (height * 0.8);
        swipe(startX, startY, startX, endY);
    }

    @Override
    public void swipeLeft() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        int startX = (int) (width * 0.8);
        int endX = (int) (width * 0.2);
        int y = height / 2;
        swipe(startX, y, endX, y);
    }

    @Override
    public void swipeRight() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        int startX = (int) (width * 0.2);
        int endX = (int) (width * 0.8);
        int y = height / 2;
        swipe(startX, y, endX, y);
    }

    private void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger"
        );
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY
                )
        );
        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );
        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(500),
                        PointerInput.Origin.viewport(),
                        endX,
                        endY
                )
        );
        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );
        driver.perform(
                Collections.singletonList(swipe)
        );
    }

    @Override
    public void longPress(Locator locator) {
        WebElement element = waitUntilVisible(locator);

        int centerX = element.getRect().x + (element.getRect().width / 2);
        int centerY = element.getRect().y + (element.getRect().height / 2);

        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger"
        );

        Sequence longPress = new Sequence(finger, 1);

        longPress.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        centerX,
                        centerY
                )
        );

        longPress.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        longPress.addAction(
                new org.openqa.selenium.interactions.Pause(
                        finger,
                        Duration.ofSeconds(2)
                )
        );

        longPress.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Collections.singletonList(longPress)
        );
    }

    @Override
    public void dragAndDrop(Locator source, Locator target) {
        WebElement sourceElement = waitUntilVisible(source);
        WebElement targetElement = waitUntilVisible(target);

        int startX = sourceElement.getRect().x + (sourceElement.getRect().width / 2);
        int startY = sourceElement.getRect().y + (sourceElement.getRect().height / 2);

        int endX = targetElement.getRect().x + (targetElement.getRect().width / 2);
        int endY = targetElement.getRect().y + (targetElement.getRect().height / 2);

        swipe(startX, startY, endX, endY);
    }

    @Override
    public void scrollToText(String text) {
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
                                + text +
                                "\"))"
                )
        );
    }

    @Override
    public void takeScreenshot(String fileName) {
        try {
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File target = new File(
                    "screenshots/" + fileName + ".png"
            );

            target.getParentFile().mkdirs();

            Files.copy(
                    source.toPath(),
                    target.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to capture screenshot",
                    e
            );
        }
    }

    public void waitVisible(Locator locator, int timeoutInSeconds) {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(timeoutInSeconds)
        ).until(
                ExpectedConditions.visibilityOfElementLocated(
                        resolve(locator)
                )
        );
    }

    public void waitClickable(Locator locator, int timeoutInSeconds) {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(timeoutInSeconds)
        ).until(
                ExpectedConditions.elementToBeClickable(
                        resolve(locator)
                )
        );
    }
}