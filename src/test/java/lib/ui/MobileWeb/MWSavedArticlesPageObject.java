package lib.UI.MobileWeb;

import lib.UI.SavedArticlesPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSavedArticlesPageObject extends SavedArticlesPageObject {

    static {
        ARTICLE_ELEMENT = "css:li.with-watchstar";
        DELETE_BUTTON = "xpath://li[@title='{SUBSTRING}']//a[contains(@href, 'action=unwatch')]";
        ARTICLE_NAME = "xpath://li[@title='{SUBSTRING}']";
    }

    public MWSavedArticlesPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
