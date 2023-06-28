package lib.UI.Android;

import lib.UI.SavedArticlesPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSavedArticlesPageObject extends SavedArticlesPageObject {
    public AndroidSavedArticlesPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        SAVED_LIST_NAME = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
                ARTICLE_ELEMENT = "id:org.wikipedia:id/page_list_item_title";
                ARTICLE_NAME = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']";
    }
}
