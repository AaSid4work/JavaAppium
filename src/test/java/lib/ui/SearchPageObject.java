package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject {


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }


   protected  static  String
            SEARCH_INIT_ELEMENT ,
            SEARCH_INPUT ,
            SEARCH_RESULT_BY_SUBSTRING_TPL ,
            SEARCH_RESULT_ELEMENT ,
            SEARCH_RESULT_LIST,
            SEARCH_CANCEL_BUTTON ,
            SEARCH_EMPTY_RESULT_ELEMENT,
           CLEAR_SEARCH_LINE,
            SEARCH_RESULT_BY_STRING_ON_PAGE_TPL ,
            ARTICLE_TITLE_AND_DESCRIPTION ;



    /*TEMPLATES METHODS */
    private static String GetResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    /*TEMPLATES METHODS */
    public void initSearchInput()
    {
        this.waitForElementAndClick(
                SEARCH_INIT_ELEMENT,
                "Cannot find and click search init element",
                15);

        this.waitForElementPresent(
                SEARCH_INIT_ELEMENT,
                "Cannot find search input after clicking init element",
                15);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(
                SEARCH_CANCEL_BUTTON,
                "Cannot find X to cancel search",
                10);
    }
    public void waitForCancelButtonToDissAppear()
    {
        this.waitForElementNotPresent(
                SEARCH_CANCEL_BUTTON
                ,"Search Cancel button is steel present",
                10);
    }
    public void ClickCancelSearch ()
    {
        this.waitForElementAndClick(
                SEARCH_CANCEL_BUTTON
                ,"Cannot find X to click cancel search",
                10);
    }
    public void typeSearchLine(String search_line){
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public static String getSearchResultXpathByTitleAndDescription(String title, String description) {
        return ARTICLE_TITLE_AND_DESCRIPTION
                .replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);

    }

    public  void waitForSearchResult(String substring)
    {
        String SearchResultXpath = GetResultSearchElement (substring);
        this.waitForElementPresent(
                SearchResultXpath
                ,"Cannot find search result with substring"+ substring,
                10);
    }
    public void waitForEmptyResultLabel(){
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);
    }

    public  void waitForSearchResultOnPage()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_BY_STRING_ON_PAGE_TPL
                ,"Cannot find search result with substring",
                10);
    }
    public void assertThereIsNoResultOfSearch(){
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }
    public  void clickByArticleWithSubstring (String substring)
    {
        String SearchResultXpath = GetResultSearchElement (substring);
        this.waitForElementAndClick(
                SearchResultXpath,
                "Cannot find and click search result with substring"+ substring,
                10);
    }
    public int getAmountOfFoundArticles(){
        this.waitForElementPresent(
                SEARCH_INIT_ELEMENT,
                "Cannot find anything by the result",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }



}
