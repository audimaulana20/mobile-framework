package automation.testcase;

import automation.base.BaseTest;
import automation.driver.DriverManager;
import automation.module.login.LoginModel;
import automation.module.login.LoginPage;
import automation.module.login.LoginSteps;
import automation.module.payment.PaymentPage;
import automation.module.payment.PaymentSteps;
import org.testng.annotations.Test;

public class CheckOutPaymentJourneyTest extends BaseTest {

    private LoginSteps loginSteps;
    private PaymentSteps paymentSteps;
    private LoginModel loginModel;

    @Override
    public void initInstance() {
        super.initInstance();
        loginSteps = new LoginPage(DriverManager.getDriver());
        paymentSteps = new PaymentPage(DriverManager.getDriver());
        loginModel = new LoginModel();
    }

    @Test
    public void journeyCheckOutPayment() {
        loginSteps.loginToApp(loginModel.username, loginModel.password);
        paymentSteps.checkoutProduct();
        paymentSteps.processToPayment();
    }
}