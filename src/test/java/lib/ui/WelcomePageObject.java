package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {
    protected static  String
    STEP_LEARN_MORE_LINK ,
    STEP_NEW_WAYS_TO_EXPLORE_TEXT ,
    STEP_ADD_OR_ADDED_PREFER_LANG_LINK ,
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK ,
    NEXT_LINK ,
    GET_STARTED_BUTTON ,
    SKIP ;
    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(
                STEP_LEARN_MORE_LINK,
                "Cannot find 'LearnMore'",
                10
        );
    }

    public void ClicknextButton()
    {
        this.waitForElementAndClick(NEXT_LINK,
                "Cant find 'Next' button",
                10
        );
    }
    public void waitForNewWayToExplore () {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'Новые способы изучения'",
                10
        );
    }
    public void waitForAddedPreferLangText () {
        this.waitForElementPresent(
                STEP_ADD_OR_ADDED_PREFER_LANG_LINK,
                "Cannot find link to change language'",
                10
        );
    }
    public void waitForLearnMoreAboutDataCollectedText () {
        this.waitForElementPresent(
                STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find link to data collected'",
                10
        );
    }
    public void ClickGetStartedButton ()
    {
        this.waitForElementAndClick(
                GET_STARTED_BUTTON,
                "cannot find Start button",
                10);
    }

    public void clickskip() {
        this.waitForElementAndClick(
                SKIP,
                "Cannot find and click skip button",
                5);
    }

}