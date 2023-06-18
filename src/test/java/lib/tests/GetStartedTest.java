package lib.tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import lib.ui.IOS.iOSWelcomePageObject;

public class GetStartedTest  extends CoreTestCase {

    @Test
    public void testTestPassThroghWelcome()
    {
        iOSWelcomePageObject WelcomePage = new iOSWelcomePageObject(driver);
        if (Platform.getInstance().isAndroid())
        {
            return;
        }


        WelcomePage.waitForLearnMoreLink();
        WelcomePage.ClicknextButton();

        WelcomePage.waitForNewWayToExplore();
        WelcomePage.ClicknextButton();

        WelcomePage.waitForAddedPreferLangText();
        WelcomePage.ClicknextButton();

        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.ClickGetStartedButton();
    }
}
