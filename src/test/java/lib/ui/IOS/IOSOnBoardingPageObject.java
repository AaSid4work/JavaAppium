package lib.UI.IOS;

import lib.UI.OnBoardingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSOnBoardingPageObject extends OnBoardingPageObject {
    public IOSOnBoardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
                ONBOARDING_SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";
                LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']";
                ONBOARDING_NEXT_BUTTON = "xpath://XCUIElementTypeButton[@name='Next']";
                TITLE_LABEL_NEW_WAYS = "xpath://XCUIElementTypeStaticText[@name='New ways to explore']";
                EDIT_LANGUAGE_LINK = "xpath://XCUIElementTypeStaticText[@name='Add or edit preferred languages']";
                LEARN_MORE_DATA_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about data collected']";
                GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']";
    }
}
