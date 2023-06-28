package lib.UI.MobileWeb;

import lib.UI.NavigationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationPageObject extends NavigationPageObject {
    static {
        SAVED_BUTTON = "css:li>a.menu__item--watchlist";
        BURGER_MENU = "xpath://label[@id='mw-mf-main-menu-button']";
    }

    public MWNavigationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
