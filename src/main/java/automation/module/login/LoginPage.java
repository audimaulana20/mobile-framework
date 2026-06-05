package automation.module.login;

import automation.base.BasePage;
import automation.base.Verify;
import io.appium.java_client.AppiumDriver;

public class LoginPage extends BasePage<LoginLocator> implements LoginSteps{

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected void setupLocator() {
        this.mLocator = new LoginLocator();
    }

    @Override
    public void loginToApp(String username, String password) {
        element.waitVisible(mLocator.BUTTON_ACCOUNT);
        element.tap(mLocator.BUTTON_ACCOUNT);
        element.waitVisible(mLocator.BUTTON_LOGIN_REGISTER);
        element.tap(mLocator.BUTTON_LOGIN_REGISTER);
        element.waitVisible(mLocator.INPUT_PHONE_EMAIL);
        element.type(mLocator.INPUT_PHONE_EMAIL, username);
        element.tap(mLocator.BUTTON_LOGIN);
        element.waitVisible(mLocator.INPUT_PASSWORD);
        element.type(mLocator.INPUT_PASSWORD, username);
        element.tap(mLocator.BUTTON_LOGIN);
        element.waitVisible(mLocator.BUTTON_LATER);
        element.tap(mLocator.BUTTON_LATER);
        element.waitVisible(mLocator.INFO_PHONE_NUMBER);
        element.waitVisible(mLocator.INFO_PHONE_NUMBER);
        String actualPhoneNumber = element.getText(mLocator.INFO_PHONE_NUMBER);
        Verify.equals(actualPhoneNumber, username, "Successfully login to app");
    }
}
