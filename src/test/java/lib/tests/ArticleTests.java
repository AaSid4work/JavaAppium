package lib.tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests  extends CoreTestCase {
    @Test
    public void testCompareArticleTitle() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }

    //@Test
//    public void testSwipeArticle() {
//        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
//
//        searchPageObject.initSearchInput();
//        searchPageObject.typeSearchLine("Java");
//        if (Platform.getInstance().isAndroid()){
//            searchPageObject.clickByArticleWithSubstring("Search Wikipedia");
//        } else {
//            searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
//        }
//
//        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
//        articlePageObject.getArticleTitle();
//        articlePageObject.swipeToFooter();
//    }
}