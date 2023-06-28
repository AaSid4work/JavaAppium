package lib.UI.Factories;

import lib.Platform;
import lib.UI.Android.AndroidArticlePageObject;
import lib.UI.ArticlePageObject;
import lib.UI.IOS.IOSArticlePageObject;
import lib.UI.MobileWeb.MWArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSArticlePageObject(driver);
        } else {
            return new MWArticlePageObject(driver);
        }
    }
}
