package lib.UI.IOS;

import lib.UI.NavigationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationPageObject extends NavigationPageObject {
    public IOSNavigationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        SAVED_BUTTON = "id:Saved";
    }
}
