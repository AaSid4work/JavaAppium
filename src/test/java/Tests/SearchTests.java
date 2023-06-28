package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.Platform;
import lib.UI.Factories.OnBoardingPageObjectFactory;
import lib.UI.Factories.SearchPageObjectFactory;
import lib.UI.MainPageObject;
import lib.UI.OnBoardingPageObject;
import lib.UI.SearchPageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Tests for Search")
public class SearchTests extends CoreTestCase {
    @Test
    @Severity(value = SeverityLevel.NORMAL)
    @Feature(value = "Search")
    @DisplayName("Checking Search Input Field contains text")
    public void testInputFieldContainsText() {
        OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
        OnBoardingPageObject.skipOnboarding();
        MainPageObject MainPageObject = new MainPageObject(driver);
        MainPageObject.assertElementHasText(
                "xpath://androidx.cardview.widget.CardView/android.widget.TextView",
                "Search Wikipedia",
                "Search bar text is invalid",
                5
        );
    }

    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @DisplayName("Checking that we can clear input field")
    public void testCancelSearch() {
        OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
        OnBoardingPageObject.skipOnboarding();
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String search_word = "Java";
        SearchPageObject.searchText(search_word);
        SearchPageObject.searchResultsExist();
        SearchPageObject.clearSearch();
        SearchPageObject.searchResultsIsEmpty();
    }

    @Test
    @Severity(value = SeverityLevel.NORMAL)
    @DisplayName("Checking that we have 6 results on screen")
    @Description("We check that we have only 6 results on the screen after search")
    public void testAssertTitlesFromSearch() {
        OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
        OnBoardingPageObject.skipOnboarding();
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String search_word = "Java";
        SearchPageObject.searchText(search_word);
        int number_of_articles_on_screen = 6;
        Assertions.assertEquals(number_of_articles_on_screen, SearchPageObject.getSearchResultsList().size());
        SearchPageObject.assertArticleTitles(search_word);
    }

    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @DisplayName("Checking that results of search are correct")
    @Description("We check that 3 top results is correct for search result '{search_word}'")
    public void testSearchResultsCorrect() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
            OnBoardingPageObject.skipOnboarding();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String search_word = "Java";
        SearchPageObject.searchText(search_word);
        List<String> expected_titles = Arrays.asList("Java", "Programming languiges");
        List<String> expected_descriptions = Arrays.asList("Java", "Programming languiges");
        SearchPageObject.assertTitlesAndDescriptionsInSearchResult(expected_titles, expected_descriptions);
    }
}
