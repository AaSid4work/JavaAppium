package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.WelcomePageObject;

public class iOSWelcomePageObject extends WelcomePageObject {
    static {
                STEP_LEARN_MORE_LINK = "id:Википедия создается совместно волонтерами и состоит из более 40 миллионов статей на более чем 300 языках.";
                STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:Новые способы изучения";
                STEP_ADD_OR_ADDED_PREFER_LANG_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Добавить или изменить предпочтительные языки\"]";
                STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Узнать подробнее о сборе данных\"]";
                NEXT_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Далее\"]";
                GET_STARTED_BUTTON = "xpath://XCUIElementTypeStaticText[@name=\"Начать\"]";
}
    public iOSWelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}