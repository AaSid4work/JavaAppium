package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.Platform;
import lib.UI.*;
import lib.UI.Factories.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavedArticlesTests extends CoreTestCase {
    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article"), @Feature(value = "SavedArticles")})
    @DisplayName("Checking that we can delete 1 article from saved list")
    @Description("We add 2 articles in watchlist/saved, and after delete one of article from there")
    public void testTwoArticlesSave() throws Exception {
        if (Platform.getInstance().isMW()) {
            System.out.println("Start");
        } else {
            OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
            OnBoardingPageObject.skipOnboarding();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String search_word = "Java";
        SearchPageObject.searchText(search_word);
        String article_title_1 = "Programming language";
        String article_title_2 = "JavaServer Pages";
        SearchPageObject.openArticle(article_title_1);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String list_name = "Learning languiges";
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.firstSaveArticleToList(list_name);
            driver.navigate().back();
            SearchPageObject.openArticle(article_title_2);
            ArticlePageObject.saveArticleToList(list_name);
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().back();
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.saveFirstArticleToListIOS(list_name, article_title_1);
            driver.navigate().back();
            SearchPageObject.openArticle(article_title_2);
            ArticlePageObject.saveArticleToListIOS(list_name, article_title_2);
            driver.navigate().back();
            SearchPageObject.closeSearch();
        } else {
            String username = "anna.sidorova";
            String password = "78392hh";
            ArticlePageObject.firstSaveArticleMW();
            LoginPageObject LoginPageObject = LoginPageObjectFactory.get(driver);
            LoginPageObject.enterCredentials(username, password);
            LoginPageObject.submitLogin();
            ArticlePageObject.assertArticleHasAddedToWatchList();
            SearchPageObject.searchText(search_word);
            SearchPageObject.openArticle(article_title_2);
            ArticlePageObject.saveArticleMW(article_title_2);
        }
        NavigationPageObject NavigationPageObject = NavigationPageObjectFactory.get(driver);
        NavigationPageObject.savedPage();
        SavedArticlesPageObject SavedArticlesPageObject = SavedArticlePageObjectFactory.get(driver);
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            if (Platform.getInstance().isIOS()) {
                SavedArticlesPageObject.closePopUp();
                SavedArticlesPageObject.chooseReadingLists();
            }
            SavedArticlesPageObject.openSavedList(list_name);
            SavedArticlesPageObject.swipeToDeleteArticle(article_title_1);
            SavedArticlesPageObject.assertAfterDeleteArticle(article_title_1);
            SavedArticlesPageObject.openArticle(article_title_2);
            if (Platform.getInstance().isAndroid()) {
                ArticlePageObject.assertArticleHasTitle(article_title_2);
            } else {
                ArticlePageObject.assertArticleTitleInTableOfContents(article_title_2);
            }
        } else {
            SavedArticlesPageObject.swipeToDeleteArticle(article_title_1);
            driver.navigate().refresh();
            driver.navigate().refresh();
            SavedArticlesPageObject.assertAfterDeleteArticle(article_title_1);
            SavedArticlesPageObject.openArticle(article_title_2);
            ArticlePageObject.assertArticleHasTitle(article_title_2);

        }


    }
}
