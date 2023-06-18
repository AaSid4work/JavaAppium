package lib.ui.IOS;
import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "id:Язык программирования";
        CLOSE_BUTTON  = " id:Отменить";

    }

    public iOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}