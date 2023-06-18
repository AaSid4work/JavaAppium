package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {
    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    protected static String

            TITLE,
            ARTICLE_TITLE,
            OPTION_BUTTON,
            ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_MAME_INPUT,
            MY_LIST_OK_BUTTON,
            MY_SAVED_FOLDER_NAME,
            CLOSE_ARTICLE_BUTTON,
            ELEMENT_TO_FIND_AFTER_SWIPE_TPL,
            FOOTER_ELEMENT,
            OPTION_ADD_TO_MY_LIST_BUTTON,
            MY_CREATE_LIST;


    private static String GetSearchElementByxPath (String search_element)
{
    return ELEMENT_TO_FIND_AFTER_SWIPE_TPL.replace("{NAME_OF_ELEMENT}",search_element);
}
    private static String GetNameOfSavedFolder (String name_of_saved_folder)
    {
        return MY_SAVED_FOLDER_NAME.replace("{SAVED_FOLDER_NAME}",name_of_saved_folder);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(
                TITLE,
                "Cannot find article title on page",
                15);
    }
    public void ClickInSavedFolder (String name_of_saved_folder)
    {
        String SavedFolderNameXpath = GetNameOfSavedFolder(name_of_saved_folder);
                this.waitForElementAndClick(
                        SavedFolderNameXpath,
                        "Cannot find saved folder with name "+name_of_saved_folder,
                        5
                );
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else{
            return title_element.getAttribute("name");
        }
    }

    public WebElement waitForTitleElementMy() {
        return this.waitForElementPresent (
                TITLE,
                "Cannot find article title on page",
                15);
    }



    public void AddArticleToMyList (String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTION_BUTTON,
                "cannot find button 'more options'",
                5
        );

        this.waitForElementAndClick(
                 ADD_TO_MY_LIST_BUTTON,
                "cannot find option to add article to reading list'",
                5
        );
        this.waitForElementAndClick(
               ADD_TO_MY_LIST_OVERLAY,
                "cannot find GOT IT tip overlay",
                5
        );
        this.waitForElementAndClear(
                MY_LIST_MAME_INPUT,
                "Cannot find input to set name of article folder ",
                5
        );
        this.waitForElementAndSendKeys(
               MY_LIST_MAME_INPUT,
                "Learning Programming",
                "Cannot put text into article folder input",
                5
        );
        this.waitForElementAndClick(
               MY_LIST_OK_BUTTON,
                "cannot press OK button",
                5
        );

    }
    public void CloseArticle ()
    {
        waitForElementAndClick(
            CLOSE_ARTICLE_BUTTON,
                "cannot close article, cannot find x button",
                5
        );
    }
    public void AddArticleToFolderInMyList (String name_of_saved_folder)
    {
        this.waitForElementAndClick(
                OPTION_BUTTON,
                "cannot find button 'more options'",
                5
        );
        this.waitForElementAndClick(
               ADD_TO_MY_LIST_BUTTON,
                "cannot find option to add article to reading list'",
                5
        );

        ClickInSavedFolder(name_of_saved_folder);

        this.waitForElementAndClick(
              MY_LIST_OK_BUTTON,
                "cannot press OK button",
                5
        );
    }
    public void addArticlesToMySaved(){
        this.waitForElementAndClick(OPTION_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list",5);
    }

    public void checkArticleWithoutWait(){
        this.assertElementPresent(
                TITLE,
                "Cannot find Article"
        );
    }
    public void assertArticleHasTitle(String article_title) {
        String article_title_actual = waitForElementPresent(
                ARTICLE_TITLE,
                "Not find title of article",
                5
        ).getText();
        Assert.assertEquals(
                article_title,
                article_title_actual,
                "Wrong article title"
        );
    }
    public void swipeToFooter(){

        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    80
            );
        } else {
            this.swipeUpTitleElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    80 );
        }
    }

}
