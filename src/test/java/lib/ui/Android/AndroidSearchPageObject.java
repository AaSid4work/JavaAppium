package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{
   static {
       SEARCH_INIT_ELEMENT = "xpath://*[contains (@text, 'Search Wikipedia')]";
               SEARCH_INPUT = "xpath://*[contains (@text, 'Search…')]";
               SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']//*[@text='{SUBSTRING}']";
               SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
               SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
               SEARCH_RESULT_BY_STRING_ON_PAGE_TPL = "id:org.wikipedia:id/view_page_subtitle_text";
               ARTICLE_TITLE_AND_DESCRIPTION = "xpath://android.view.ViewGroup/android.widget.TextView[@text='{TITLE}']/../android.widget.TextView[@text='{DESCRIPTION}']/..";
   }
    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }


}
