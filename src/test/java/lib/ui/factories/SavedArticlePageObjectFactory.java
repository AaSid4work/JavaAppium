package lib.UI.Factories;

import lib.Platform;
import lib.UI.Android.AndroidSavedArticlesPageObject;
import lib.UI.IOS.IOSSavedArticlesPageObject;
import lib.UI.MobileWeb.MWSavedArticlesPageObject;
import lib.UI.SavedArticlesPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SavedArticlePageObjectFactory {
    public static SavedArticlesPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSavedArticlesPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSSavedArticlesPageObject(driver);
        } else {
            return new MWSavedArticlesPageObject(driver);
        }
    }
}
