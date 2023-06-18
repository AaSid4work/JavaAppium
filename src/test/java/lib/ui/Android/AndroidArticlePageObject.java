package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;



public class AndroidArticlePageObject extends ArticlePageObject {

        static {
            TITLE = "org.wikipedia:id/view_page_title_text";
            FOOTER_ELEMENT = "xpath://android.view.View/android.view.View[1]/android.view.View[1]";
            OPTION_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
                    ADD_TO_MY_LIST_BUTTON = "//*[@text = 'Add to reading list']";
                    ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button";
                    MY_LIST_MAME_INPUT = "org.wikipedia:id/text_input";
                    MY_LIST_OK_BUTTON = "//*[@text = 'OK']";
                    MY_SAVED_FOLDER_NAME = "//*[@text = '{SAVED_FOLDER_NAME}']";
                    CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton [@content-desc = 'Navigate up']";
                    ELEMENT_TO_FIND_AFTER_SWIPE_TPL = "//*[contains(@text,'{NAME_OF_ELEMENT}')]";
        }
        public AndroidArticlePageObject(AppiumDriver driver)
        {
            super(driver);
        }
    }
