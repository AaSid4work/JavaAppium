package lib.UI.MobileWeb;

import lib.UI.LoginPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWLoginPageObject extends LoginPageObject {
    public MWLoginPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        LOGIN_FIELD = "css:input.loginText";
        PASSWORD_FIELD = "css:input.loginPassword";
        SUBMIT_BUTTON = "css:button.mw-htmlform-submit";
    }
}
