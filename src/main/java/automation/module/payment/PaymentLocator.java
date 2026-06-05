package automation.module.payment;

import automation.base.*;

public class PaymentLocator extends BaseLocator {

    public final Locator BUTTON_HOME = xpath("//android.widget.TextView[@text=\"Beranda\"]");
    public final Locator BUTTON_CLOSE_BANNER = xpath("//android.widget.ImageView[@resource-id=\"com.indomaret.klikindomaret:id/58n\"]");
    public final Locator INPUT_SEARCH_PRODUCT = xpath("//android.widget.TextView[@resource-id=\"com.indomaret.klikindomaret:id/5rm\"]");
    public final Locator BUTTON_ADD_PRODUCT = xpath("(//android.widget.FrameLayout[@resource-id=\"com.indomaret.klikindomaret:id/8d5\"])[1]");
    public final Locator BUTTON_CHECKOUT_PROCESS = id("(com.indomaret.klikindomaret:id/8k3");
    public final Locator INFO_PRICE = id("com.indomaret.klikindomaret:id/7hn");
    public final Locator BUTTON_SHIPMENT = id("com.indomaret.klikindomaret:id/bq6");
    public final Locator BUTTON_INSTANT = xpath("//android.widget.TextView[@resource-id=\"com.indomaret.klikindomaret:id/ffp\" and contains(@text,\"Instan\"])");
    public final Locator BUTTON_CONFIRM_SHIPMENT = id("com.indomaret.klikindomaret:id/did");
    public Locator INFO_SEARCH_RESULT(String product) {
        return xpath("(//android.widget.EditText)[" + product + "]");
    }
}
