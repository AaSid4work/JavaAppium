package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.Factories.ArticlePageObjectFactory;
import lib.UI.Factories.OnBoardingPageObjectFactory;
import lib.UI.Factories.SearchPageObjectFactory;
import lib.UI.OnBoardingPageObject;
import lib.UI.SearchPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    @Feature(value = "Article")
    @Severity(value = SeverityLevel.CRITICAL)
    @DisplayName("Checking that article have right title")
    @Description("We search '{search_word}' and assert that inside of article same title as in search results")
    public void testFindingArticleTitle() {
        OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
        OnBoardingPageObject.skipOnboarding();
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String search_word = "Java";
        SearchPageObject.searchText(search_word);
        String article_title = "Programming language";
        SearchPageObject.openArticle(article_title);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.assertArticleHasTitle(article_title);

    }
}
