package lib.UI.IOS;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {
    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        SEARCH_CONTAINER = "id:Search Wikipedia";
        SEARCH_INPUT_FIELD = "id:Search Wikipedia";
        CLEAR_SEARCH_BUTTON = "id:Clear text";
        CLOSE_SEARCH_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_EMPTY_CONTAINER = "id:No recent searches yet";
        PAGE_LIST = "xpath://XCUIElementTypeOther[2]/XCUIElementTypeCollectionView";
        ARTICLE_TITLE_AND_DESCRIPTION = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']/../XCUIElementTypeStaticText[@name='{DESCRIPTION}']/..";
        ARTICLE_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
    }
}
