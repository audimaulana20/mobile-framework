package automation.module.payment;

import automation.base.BasePage;
import automation.base.Verify;
import io.appium.java_client.AppiumDriver;

public class PaymentPage extends BasePage<PaymentLocator> implements PaymentSteps{

    int priceProduct;
    int shippingFee;
    int totalPrice;
    int actualTotalPrice;
    public PaymentPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected void setupLocator() {
        this.mLocator = new PaymentLocator();
    }

    @Override
    public void checkoutProduct() {
        element.waitVisible(mLocator.BUTTON_HOME);
        if (element.isDisplayed(mLocator.BUTTON_CLOSE_BANNER)) {
            element.tap(mLocator.BUTTON_CLOSE_BANNER);
        }
        element.waitVisible(mLocator.BUTTON_HOME);
            element.tap(mLocator.BUTTON_HOME);
            element.waitVisible(mLocator.INPUT_SEARCH_PRODUCT);
            element.tap(mLocator.INPUT_SEARCH_PRODUCT);
            element.type(mLocator.INPUT_SEARCH_PRODUCT, "Aqua");
            element.tap(mLocator.INFO_SEARCH_RESULT("Aqua"));
            element.waitVisible(mLocator.BUTTON_ADD_PRODUCT);
            element.tap(mLocator.BUTTON_ADD_PRODUCT);
            element.waitVisible(mLocator.BUTTON_ADD_PRODUCT);
            element.tap(mLocator.BUTTON_ADD_PRODUCT);
            element.waitVisible(mLocator.BUTTON_CHECKOUT_PROCESS);
            element.tap(mLocator.BUTTON_CHECKOUT_PROCESS);
            element.waitVisible(mLocator.INFO_PRICE);
            String price = element.getText(mLocator.INFO_PRICE);
            priceProduct = Integer.parseInt(price.replaceAll("[^0-9]", ""));
    }

    @Override
    public void processToPayment() {
        element.waitVisible(mLocator.BUTTON_SHIPMENT);
        element.tap(mLocator.BUTTON_SHIPMENT);
        element.waitVisible(mLocator.BUTTON_INSTANT);
        String shipping = element.getText(mLocator.BUTTON_INSTANT);
        shippingFee = Integer.parseInt(shipping.replaceAll("[^0-9]", ""));
        element.tap(mLocator.BUTTON_INSTANT);
        element.waitVisible(mLocator.BUTTON_CONFIRM_SHIPMENT);
        element.tap(mLocator.BUTTON_CONFIRM_SHIPMENT);
        element.waitVisible(mLocator.INFO_PRICE);
        Verify.isTrue(element.isDisplayed(mLocator.BUTTON_INSTANT), "Successfully select instant shipment");
        String actualTotal = element.getText(mLocator.INFO_PRICE);
        actualTotalPrice = Integer.parseInt(actualTotal.replaceAll("[^0-9]", ""));
        Verify.isTrue(calculateTotalPrice(), "Successfully calculate total price");
    }

    private boolean calculateTotalPrice() {
        totalPrice = priceProduct + shippingFee;
        return totalPrice == actualTotalPrice;
    }

}
