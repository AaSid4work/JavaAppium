package lib.UI.Factories;

import lib.Platform;
import lib.UI.MobileWeb.MWLoginPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPageObjectFactory {
    public static MWLoginPageObject get(RemoteWebDriver driver) throws Exception {
        if (Platform.getInstance().isMW()) {
            return new MWLoginPageObject(driver);
        } else {
            throw new Exception("There is no code for this platform yet");
        }
    }

}
