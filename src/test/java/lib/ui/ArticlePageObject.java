package lib.UI;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObject extends MainPageObject {
    public static String
            SAVE_BUTTON,
            ADD_TO_LIST_BUTTON,
            ADD_TO_LIST_BUTTON_IS_PRESSED,
            ADD_TO_LIST_INPUT_FIELD,
            LIST_TITLE,
            SNACKBAR_AFTER_SAVE,
            ARTICLE_TITLE,
            CREATE_LIST_BUTTON,
            CREATE_NEW_LIST_BUTTON,
            ADD_TO_LIST_BUTTON_FROM_SNACKBAR,
            TABLE_OF_CONTENTS_BUTTON,
            ARTICLE_TITLE_IN_CONTENTS,
            LOG_IN_BUTTON,
            CLOSE_POP_UP_MW,
            ADD_TO_LIST_OK_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Saving first article to list")
    public void firstSaveArticleToList(String list_name) {
        waitForElementAndClick(
                SAVE_BUTTON,
                "Not find Save Button",
                5
        );
        takeScreenshot("state_after_clicking_save");
        waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Not find Add to List Button",
                5
        );
        takeScreenshot("state_after_clicking_add_to_list");
        waitForElementAndSendKeys(
                ADD_TO_LIST_INPUT_FIELD,
                "Not find text field",
                list_name,
                5
        );
        takeScreenshot("list_input");
        waitForElementAndClick(
                ADD_TO_LIST_OK_BUTTON,
                "Not find OK Button",
                15
        );
        takeScreenshot("state_after_adding_article");


    }

    @Step("Saving first article to list")
    public void saveFirstArticleToListIOS(String list_name, String article_title) {
        waitForElementAndClick(
                SAVE_BUTTON,
                "Not find Save Button",
                5
        );
        takeScreenshot("state_after_clicking_save");
        waitForElementAndClick(
                getAddToListXpath(article_title),
                "Not find Add to List Button",
                5
        );
        takeScreenshot("state_after_clicking_add_to_list");
        waitForElementAndClick(
                CREATE_NEW_LIST_BUTTON,
                "Not find Create a new list Button",
                5
        );
        takeScreenshot("state_after_clicking_crate_new_list");
        waitForElementAndSendKeys(
                ADD_TO_LIST_INPUT_FIELD,
                "Not find Input field",
                list_name,
                5);
        takeScreenshot("list_input");
        waitForElementAndClick(
                CREATE_LIST_BUTTON,
                "Not find Create Button",
                5);
        takeScreenshot("state_after_adding_article");
    }

    @Step("Saving article to List")
    public void saveArticleToListIOS(String list_name, String article_title) {
        waitForElementAndClick(
                SAVE_BUTTON,
                "Not find Save Button",
                5
        );
        takeScreenshot("state_after_clicking_save");
        waitForElementAndClick(
                getAddToListXpath(article_title),
                "Not find Add to List Button",
                5
        );
        takeScreenshot("state_after_clicking_add_to_list");
        waitForElementAndClick(
                getListID(list_name),
                "Not find list title " + list_name,
                5
        );
        takeScreenshot("state_after_choosing_list");
        waitForElementsPresent(
                SNACKBAR_AFTER_SAVE,
                "Snackbar not presented after article save",
                5
        );
        takeScreenshot("state_after_adding_article");

    }


    @Step("Saving article to List")
    public void saveArticleToList(String list_name) {
        waitForElementAndClick(
                SAVE_BUTTON,
                "Not find Save Button",
                5
        );
        takeScreenshot("state_after_clicking_save");
        waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Not find Add to List Button",
                5
        );
        takeScreenshot("state_after_clicking_add_to_list");
        waitForElementAndClick(
                getListTitleXpath(list_name),
                "Not find " + list_name + " list",
                5
        );
        takeScreenshot("state_after_choosing_list");
        waitForElementsPresent(
                SNACKBAR_AFTER_SAVE,
                "Snackbar not presented after article save",
                5
        );
        takeScreenshot("state_after_adding_article");

    }

    private static String getListTitleXpath(String substring) {
        return LIST_TITLE.replace("{SUBSTRING}", substring);

    }

    private static String getAddToListXpath(String substring) {
        return ADD_TO_LIST_BUTTON_FROM_SNACKBAR.replace("{SUBSTRING}", substring);

    }

    private static String getArticleTitleID(String title) {
        return ARTICLE_TITLE.replace("{TITLE}", title);
    }


    @Step("Assert that title of article is correct")
    public void assertArticleHasTitle(String article_title) {
        String article_title_actual = waitForElementPresent(
                ARTICLE_TITLE,
                "Not find title of article",
                5
        ).getText();
        Assertions.assertEquals(
                article_title,
                article_title_actual,
                "Wrong article title"
        );
        takeScreenshot("state_of_article");
    }

    @Step("Assert that article title is correct in Table of contents")
    public void assertArticleTitleInTableOfContents(String article_title) {
        waitForElementAndClick(TABLE_OF_CONTENTS_BUTTON, "Not find Table of contents button", 5);
        String article_title_actual = waitForElementPresent(ARTICLE_TITLE_IN_CONTENTS, "some error", 5).getText();
        Assertions.assertEquals(
                article_title,
                article_title_actual,
                "Wrong article title"
        );
        takeScreenshot("state_of_article_toc");

    }

    public static String getListID(String list_name) {
        return "id:" + list_name;
    }

    @Step("Saving article to Watchlist without login")
    public void firstSaveArticleMW() {
        if (isElementPresented(CLOSE_POP_UP_MW, 2)) {
            waitForElementAndClick(CLOSE_POP_UP_MW, "Cannot close pop-up", 5);
        }
        waitForElementAndClick(SAVE_BUTTON, "Cannot click Save btn", 5);
        takeScreenshot("state_after_click_save");
        waitForElementAndClick(LOG_IN_BUTTON, "Cannot click Login btn", 5);
        takeScreenshot("state_after_click_login");
    }

    @Step("Saving article to Watchlist")
    public void saveArticleMW(String article_title) {
        if (isElementPresented(ADD_TO_LIST_BUTTON_IS_PRESSED, 2)) {
            assertArticleHasTitle(article_title);
            System.out.println("Article already added to watchlist");
            takeScreenshot("state_of_article_with_added_wathclist");
        } else {
            if (isElementPresented(CLOSE_POP_UP_MW, 2)) {
                waitForElementAndClick(CLOSE_POP_UP_MW, "Cannot close pop-up", 5);
            }
            assertArticleHasTitle(article_title);
            waitForElementAndClick(SAVE_BUTTON, "Cannot click Save btn", 5);
            assertArticleHasAddedToWatchList();
            takeScreenshot("state_of_article_with_added_wathclist");
        }
    }


    @Step("Assert that articles is added to watchlist")
    public void assertArticleHasAddedToWatchList() {
        waitForElementPresent(ADD_TO_LIST_BUTTON_IS_PRESSED, "Article not added to list", 5);
        takeScreenshot("state_of_article_page");
    }
}
