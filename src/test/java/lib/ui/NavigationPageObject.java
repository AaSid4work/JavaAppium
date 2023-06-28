package lib.UI;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationPageObject extends MainPageObject {
    public NavigationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public static String
            SAVED_BUTTON,
            BURGER_MENU;

    @Step("Open saved page in navigation")
    public void savedPage() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            waitForElementAndClick(
                    SAVED_BUTTON,
                    "Not find Saved Button in tab-bar",
                    5
            );
            takeScreenshot("state_after_clicking_saved_btn");
        } else {
            waitForElementAndClick(BURGER_MENU, "Burger menu not presented on this page", 5);
            takeScreenshot("burger_menu");
            tryClickElementWithAttempts(SAVED_BUTTON, "Cannot click Watchlist btn", 5);
            takeScreenshot("clicking_watchlist");
        }

    }


}
