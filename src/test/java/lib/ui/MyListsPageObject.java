package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;

abstract  public class MyListsPageObject extends MainPageObject {
    public MyListsPageObject (AppiumDriver driver)

    {
        super(driver);
    }
    protected static String
            FOLDER_BY_NAME_TPL ,
            ARTICLE_BY_TITLE_TPL ,
            CLOSE_BUTTON ;
    private static String GetFolderXpathByName (String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);

    }

    private static String getSaveArticleByTitle(String article_title){
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }
    public void OpenFolderByName(String name_of_folder)
    {
        String folderNameXpath = GetFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folderNameXpath,
                "cannot find "+ name_of_folder,
                5
        );
    }
    public void waitForArticleToAppearByTitle(String ArticleTitle )
    {
        String articleXpath = getSaveArticleByTitle(ArticleTitle);
        this.waitForElementPresent(articleXpath, "Cannot find article by title "+ArticleTitle, 13);
    }
    public void waitForArticleToDisappearByTitle(String ArticleTitle )
    {
        String articleXpath = getSaveArticleByTitle(ArticleTitle);
        this.waitForElementNotPresent(articleXpath, "saved article slill present with title"+ArticleTitle, 13);
    }
    public void swipeByArticleToDelete(String article_title){
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSaveArticleByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"
        );
        if(Platform.getInstance().isIOS()){
            this.ClickElementToTheRightUpperCorner(article_xpath,"Cannot find saved article");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void clickCloseButton(){
        this.waitForElementAndClick(
                CLOSE_BUTTON,
                "Cannot click button 'Close'",
                5
        );

}}
