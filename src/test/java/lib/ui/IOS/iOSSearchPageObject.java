package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;


public class iOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Поиск по Википедии";
        SEARCH_INPUT = "id:Поиск по Википедии";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name=\"Отменить\"]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "(xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}'])[1]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText";
        SEARCH_RESULT_LIST = "xpath://XCUIElemen tTypeCell";
        SEARCH_EMPTY_RESULT_ELEMENT = "id:Ничего не найдено";
        CLEAR_SEARCH_LINE = "id:Очистить текст";
    }
    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}