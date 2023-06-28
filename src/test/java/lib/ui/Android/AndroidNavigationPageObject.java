package lib.UI.Android;

import lib.UI.NavigationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationPageObject extends NavigationPageObject {
    public AndroidNavigationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SAVED_BUTTON = "id:org.wikipedia:id/nav_tab_reading_lists";
    }
}
