package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lib.CoreTestCase;
import lib.Platform;
import lib.UI.Factories.OnBoardingPageObjectFactory;
import lib.UI.Factories.SearchPageObjectFactory;
import lib.UI.OnBoardingPageObject;
import lib.UI.SearchPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OnBoardingTests extends CoreTestCase {
    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @Feature(value = "Onboarding")
    @DisplayName("Checking onboarding flow")
    @Description("We go through Onboarding Flow")
    public void testOnboardingFlow() {
        if(Platform.getInstance().isAndroid()){
            return;
        }
        OnBoardingPageObject OnBoardingPageObject = OnBoardingPageObjectFactory.get(driver);
        OnBoardingPageObject.assertLearnMoreLink();
        OnBoardingPageObject.nextButtonClick();
        OnBoardingPageObject.assertTitleNewWays();
        OnBoardingPageObject.nextButtonClick();
        OnBoardingPageObject.assertEditLanguageLink();
        OnBoardingPageObject.nextButtonClick();
        OnBoardingPageObject.assertLearnMoreDataLink();
        OnBoardingPageObject.clickGetStartedButton();
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.assertSearchContainerIsPresented();
    }
}
