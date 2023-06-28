package lib.UI;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public static String
            SEARCH_CONTAINER,
            SEARCH_INPUT_FIELD,
            CLEAR_SEARCH_BUTTON,
            CLOSE_SEARCH_BUTTON,
            SEARCH_EMPTY_CONTAINER,
            PAGE_LIST,
            ARTICLE_TITLE_AND_DESCRIPTION,
            ARTICLE_TITLE_TPL;

    @Step("Searching '{value}' string")
    public void searchText(String value) {
        waitForElementAndClick(
                SEARCH_CONTAINER,
                "Not find search container on the page",
                5
        );
        waitForElementAndSendKeys(
                SEARCH_INPUT_FIELD,
                "Not find input field",
                value,
                5
        );
        takeScreenshot("search_input");

    }

    @Step("Assert that search result exist")
    public void searchResultsExist() {
        for (WebElement searchResult : getSearchResultsList()) {
            Assertions.assertTrue(searchResult.isDisplayed(), "Titles not displayed");
        }

    }

    @Step("Clearing search field")
    public void clearSearch() {
        waitForElementAndClick(
                CLEAR_SEARCH_BUTTON,
                "Not find Close button",
                5
        );
        takeScreenshot("state_after_clear");

    }

    @Step("Assert that search result is empty")
    public void searchResultsIsEmpty() {
        waitForElementPresent(
                SEARCH_EMPTY_CONTAINER,
                "Search is not empty",
                5
        );
    }

    public List<WebElement> getSearchResultsList() {
        return waitForElementsPresent(
                PAGE_LIST,
                "Not find any articles",
                5);
    }

    @Step("Assert that search results have '{search_word}' in title")
    public void assertArticleTitles(String search_word) {
        for (WebElement articles_element : getSearchResultsList()) {
            String article_title = articles_element.getText();
            Assertions.assertTrue(article_title.contains(search_word), "Not all articles contains search-word " + search_word + " in title");
        }
    }


    private static String getSearchResultXpath(String substring) {
        return ARTICLE_TITLE_TPL.replace("{SUBSTRING}", substring);

    }

    private static String getSearchResultXpathByTitleAndDescription(String title, String description) {
        return ARTICLE_TITLE_AND_DESCRIPTION
                .replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);

    }

    @Step("Open article from search")
    public void openArticle(String article_title) {
        waitForElementAndClick(
                getSearchResultXpath(article_title),
                "Not find " + article_title + " article",
                5
        );
        takeScreenshot("article_page");
    }

    public void openArticleWithDesc(String article_title, String article_desc) {
        waitForElementAndClick(
                getSearchResultXpathByTitleAndDescription(article_title, article_desc),
                "Not find " + article_title + " article",
                5
        );
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        ;
        waitForElementPresent(
                getSearchResultXpathByTitleAndDescription(title, description),
                "Title '" + title + "' or description '" + description + "' doesn't match",
                5
        );


    }

    @Step("Assert that needed titles exist in search results")
    public void assertTitlesAndDescriptionsInSearchResult(List<String> titles, List<String> descriptions) {
        for (int i = 0; i < titles.size(); i++) {
            waitForElementByTitleAndDescription(titles.get(i), descriptions.get(i));
        }

    }

    @Step("Assert that search field exist")
    public void assertSearchContainerIsPresented() {
        waitForElementPresent(SEARCH_CONTAINER, "Not find Search Field on Main Page", 15);
        takeScreenshot("main_page_with_search");
    }

    @Step("Closing search")
    public void closeSearch() {
        waitForElementAndClick(CLOSE_SEARCH_BUTTON, "Not Find Close Button", 5);
        takeScreenshot("state_after_closing_search");
    }

    public void openSearch() {
        waitForElementAndClick(SEARCH_CONTAINER, "Not find Search btn", 5);
    }


}
