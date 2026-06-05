package automation.module.login;

import automation.base.BaseLocator;
import automation.base.Locator;

public class LoginLocator extends BaseLocator {

    public final Locator BUTTON_ACCOUNT = xpath("//android.widget.TextView[@text=\"Akun\"]");
    public final Locator BUTTON_LOGIN_REGISTER = id("com.indomaret.klikindomaret:id/did");
    public final Locator BUTTON_LOGIN = id("com.indomaret.klikindomaret:id/5mp");
    public final Locator INPUT_PHONE_EMAIL = xpath("//android.widget.EditText[@text=\"Masukkan Nomor Handphone atau Email\"]");
    public final Locator INPUT_PASSWORD = xpath("//android.widget.EditText[@text=\"Kata Sandi\"]");
    public final Locator BUTTON_LATER = id("com.indomaret.klikindomaret:id/9t1");
    public final Locator INFO_PHONE_NUMBER = xpath("//android.widget.TextView[@resource-id=\"com.indomaret.klikindomaret:id/e7q\"]");
}