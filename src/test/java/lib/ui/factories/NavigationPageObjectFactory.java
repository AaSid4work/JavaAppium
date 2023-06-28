package lib.UI.Factories;

import lib.Platform;
import lib.UI.Android.AndroidNavigationPageObject;
import lib.UI.IOS.IOSNavigationPageObject;
import lib.UI.MobileWeb.MWNavigationPageObject;
import lib.UI.NavigationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationPageObjectFactory {
    public static NavigationPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSNavigationPageObject(driver);
        } else {
            return new MWNavigationPageObject(driver);
        }
    }
}
