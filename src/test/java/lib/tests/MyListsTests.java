package lib.tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests  extends CoreTestCase {
    private static final String name_of_folder = "Learning programming";
    @Test
    public void testSaveFirstArticleToMyList() throws InterruptedException {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();

        String article_title = articlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            articlePageObject.AddArticleToMyList(name_of_folder);
        } else {
            articlePageObject.addArticlesToMySaved();
        }

        articlePageObject.CloseArticle();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        searchPageObject.ClickCancelSearch();
        navigationUI.ClickMyList();

        MyListsPageObject myListPageObject = MyListPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            myListPageObject.OpenFolderByName(name_of_folder);
        }
        myListPageObject.clickCloseButton();

        Thread.sleep(4000);

        myListPageObject.swipeByArticleToDelete(article_title);
    }

}
