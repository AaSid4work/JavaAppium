package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;


public class iOSArticlePageObject extends ArticlePageObject {


static {
        TITLE = "id:язык программирования";
        FOOTER_ELEMENT = "id:Посмотреть статью в браузере";
        OPTION_ADD_TO_MY_LIST_BUTTON = "id:Сохранить на потом";
        MY_CREATE_LIST = "id:Сохранено";
        CLOSE_ARTICLE_BUTTON = "id:Назад";
        }

public iOSArticlePageObject(AppiumDriver driver){
        super(driver);
        }

}