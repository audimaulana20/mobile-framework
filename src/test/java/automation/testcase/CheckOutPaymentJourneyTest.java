package automation.testcase;

import automation.base.BaseTest;
import automation.driver.DriverManager;
import automation.module.login.LoginPage;
import automation.module.login.LoginSteps;
import automation.module.payment.PaymentPage;
import automation.module.payment.PaymentSteps;
import org.testng.annotations.Test;

public class CheckOutPaymentJourneyTest extends BaseTest {

    private LoginSteps loginSteps;
    private PaymentSteps paymentSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        loginSteps = new LoginPage(DriverManager.getDriver());
        paymentSteps = new PaymentPage(DriverManager.getDriver());
    }

    @Test
    public void journeyCheckOutPayment() {
        loginSteps.loginToApp("08123456789", "password123");
        paymentSteps.checkoutProduct();
        paymentSteps.processToPayment();
    }
}