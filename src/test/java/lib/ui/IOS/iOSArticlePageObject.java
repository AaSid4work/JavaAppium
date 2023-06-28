package lib.UI.IOS;

import lib.UI.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        SAVE_BUTTON = "id:Save for later";
                ADD_TO_LIST_BUTTON_FROM_SNACKBAR = "xpath://XCUIElementTypeStaticText[@name='Add “{SUBSTRING}” to a reading list?']";
                CREATE_NEW_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Create a new list']";
                CREATE_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Create reading list']";
                ADD_TO_LIST_INPUT_FIELD = "xpath://XCUIElementTypeTextField[@value='reading list title']";
                LIST_TITLE= "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
                SNACKBAR_AFTER_SAVE = "xpath://XCUIElementTypeStaticText[contains(@name,'Article added to')]";
                ARTICLE_TITLE = "id:'{TITLE}'";
                TABLE_OF_CONTENTS_BUTTON = "id:Table of contents";
                ARTICLE_TITLE_IN_CONTENTS = "xpath://XCUIElementTypeCell[1]/XCUIElementTypeStaticText";

    }
}
