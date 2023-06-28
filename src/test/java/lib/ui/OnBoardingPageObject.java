package lib.UI;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OnBoardingPageObject extends MainPageObject {

    public OnBoardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public static String
            ONBOARDING_SKIP_BUTTON,
            LEARN_MORE_LINK,
            ONBOARDING_NEXT_BUTTON,
            TITLE_LABEL_NEW_WAYS,
            EDIT_LANGUAGE_LINK,
            LEARN_MORE_DATA_LINK,
            GET_STARTED_BUTTON;

    @Step("Skipping onboarding")
    public void skipOnboarding() {
        takeScreenshot("ONB_open_page");
        waitForElementAndClick(ONBOARDING_SKIP_BUTTON, "Not find Skip button", 15);
    }

    @Step("Clicking next button")
    public void nextButtonClick() {
        waitForElementAndClick(ONBOARDING_NEXT_BUTTON, "Not find Next button", 15);
    }

    @Step("Finding title 'New ways'")
    public void assertTitleNewWays() {
        waitForElementPresent(TITLE_LABEL_NEW_WAYS, "Not find Title on New ways to explore page", 15);
        takeScreenshot("ONB_second_page");
    }

    @Step("Finding 'Learn more' link")
    public void assertLearnMoreLink() {
        waitForElementPresent(LEARN_MORE_LINK, "Learn more link is not presented on this page", 15);
        takeScreenshot("ONB_first_page");
    }

    @Step("Fining 'Edit language' link")
    public void assertEditLanguageLink() {
        waitForElementPresent(EDIT_LANGUAGE_LINK, "Edit language link is not presented on this page", 15);
        takeScreenshot("ONB_third_page");
    }

    @Step("Finding 'Learn more data' link")
    public void assertLearnMoreDataLink() {
        waitForElementPresent(LEARN_MORE_DATA_LINK, "Learn more data link is not presented on this page", 15);
        takeScreenshot("ONB_fourth_page");
    }

    @Step("Click Get Started")
    public void clickGetStartedButton() {
        waitForElementAndClick(GET_STARTED_BUTTON, "Not find Get Started button", 15);
    }

}
