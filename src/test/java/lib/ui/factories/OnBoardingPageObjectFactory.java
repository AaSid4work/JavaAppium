package lib.UI.Factories;

import lib.Platform;
import lib.UI.Android.AndroidOnBoardingPageObject;
import lib.UI.IOS.IOSOnBoardingPageObject;
import lib.UI.OnBoardingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OnBoardingPageObjectFactory {
    public static OnBoardingPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidOnBoardingPageObject(driver);
        } else {
            return new IOSOnBoardingPageObject(driver);
        }
    }
}
