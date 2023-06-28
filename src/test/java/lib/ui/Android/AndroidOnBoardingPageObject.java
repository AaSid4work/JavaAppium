package lib.UI.Android;

import lib.UI.OnBoardingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidOnBoardingPageObject extends OnBoardingPageObject {
    public AndroidOnBoardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        ONBOARDING_SKIP_BUTTON = "id:org.wikipedia:id/fragment_onboarding_skip_button";
        LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']";
        ONBOARDING_NEXT_BUTTON = "org.wikipedia:id/fragment_onboarding_forward_button";
        TITLE_LABEL_NEW_WAYS = "id:org.wikipedia:id/primaryTextView";
        EDIT_LANGUAGE_LINK = "id:org.wikipedia:id/addLangContainer";
//        LEARN_MORE_DATA_LINK = "";
        GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']";
    }
}
