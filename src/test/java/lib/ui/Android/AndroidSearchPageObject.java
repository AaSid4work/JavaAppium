package lib.UI.Android;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {
    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
                SEARCH_CONTAINER = "id:org.wikipedia:id/search_container";
                SEARCH_INPUT_FIELD = "id:org.wikipedia:id/search_src_text";
                CLEAR_SEARCH_BUTTON = "id:org.wikipedia:id/search_close_btn";
                SEARCH_EMPTY_CONTAINER = "id:org.wikipedia:id/search_empty_container";
                PAGE_LIST = "id:org.wikipedia:id/page_list_item_title";
                ARTICLE_TITLE_AND_DESCRIPTION = "xpath://android.view.ViewGroup/android.widget.TextView[@text='{TITLE}']/../android.widget.TextView[@text='{DESCRIPTION}']/..";
                ARTICLE_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']";
    }
}
