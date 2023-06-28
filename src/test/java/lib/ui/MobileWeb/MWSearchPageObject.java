package lib.UI.MobileWeb;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SEARCH_CONTAINER = "id:searchIcon";
        SEARCH_INPUT_FIELD = "css:form>input[type='search']";
        CLEAR_SEARCH_BUTTON = "css:button.clear";
        CLOSE_SEARCH_BUTTON = "css:button.close";
        PAGE_LIST = "css:ul.page-list";
        ARTICLE_TITLE_AND_DESCRIPTION = "xpath://li[contains(@title, '{TITLE}') and .//div[contains(text(), '{DESCRIPTION}')]]";
        ARTICLE_TITLE_TPL = "xpath://li[contains(@title, '{SUBSTRING}')]";
    }
}

