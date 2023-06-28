package lib.UI.Factories;

import lib.Platform;
import lib.UI.Android.AndroidSearchPageObject;
import lib.UI.IOS.IOSSearchPageObject;
import lib.UI.MobileWeb.MWSearchPageObject;
import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSSearchPageObject(driver);
        } else {
            return new MWSearchPageObject(driver);
        }
    }
}
