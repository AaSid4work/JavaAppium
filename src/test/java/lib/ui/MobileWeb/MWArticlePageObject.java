package lib.UI.MobileWeb;

import lib.UI.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        SAVE_BUTTON = "xpath://a[@title='Watch']";
        ADD_TO_LIST_BUTTON_IS_PRESSED = "xpath://a[@title='Remove this page from your watchlist' or @title='Unwatch']";
        LOG_IN_BUTTON = "xpath://a[text()='Log in']";
        ;
        ARTICLE_TITLE = "xpath://h1";
        CLOSE_POP_UP_MW = "css:a[title='Hide']";

    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
