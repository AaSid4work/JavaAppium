package lib.UI;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import lib.Platform;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MainPageObject {
    public RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public WebElement assertElementHasText(String locator, String expected_text, String error_message, long timeOut) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut);
        String actual_text = element.getText();
        Assertions.assertEquals(expected_text, actual_text, error_message);
        takeScreenshot("state_of_mainpage");
        return element;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeOut) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );

    }

    public List<WebElement> waitForElementsPresent(String locator, String error_message, long timeOut) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeOut) {
        if (Platform.getInstance().isMW()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            WebElement element = waitForElementPresent(locator, error_message, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            return element;
        } else {
            WebElement element = waitForElementPresent(locator, error_message, timeOut);
            element.click();
            return element;
        }

    }


    public WebElement waitForElementAndSendKeys(String locator, String error_message, String value, long timeOut) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut);
        element.sendKeys(value);
        return element;
    }

    public void swipe(String locator, String error_message, long timeOut, String direction, double percent) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut);
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int left = location.getX();
        int top = location.getY();
        int height = size.getHeight();
        int width = size.getWidth();
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", height,
                "direction", direction,
                "percent", percent,
                "speed", 3000
        ));
    }

    public void swipeIOS(String locator, String error_message, long timeOut, String direction) {
        WebElement element = waitForElementPresent(locator, error_message, timeOut);
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: swipe", params);
    }

    public WebElement assertElementPresent(String locator, String error_message) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        By by = getLocatorByString(locator);
        try {
            WebElement element = driver.findElement(by);
            return element;
        } catch (NoSuchElementException e) {
            throw new AssertionError(error_message);
        }


    }

    private By getLocatorByString(String locator_with_type) {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];
        if (by_type.equals("id")) {
            return By.id(locator);
        } else if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Wrong type of locator " + by_type);
        }

    }

    public boolean isElementPresented(String locator, long timeOut) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void tryClickElementWithAttempts(String locator, String error, int amount_of_attempts) {
        if (isElementPresented(locator, 5)) {
            int current_attempts = 0;
            boolean need_more_attempts = true;
            while (need_more_attempts) {
                try {
                    waitForElementAndClick(locator, error, 1);
                    need_more_attempts = false;
                } catch (Exception e) {
                    if (current_attempts > amount_of_attempts) {
                        waitForElementAndClick(locator, error, 1);
                    }
                }
                ++current_attempts;
            }
        }
    }

    public String takeScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir" + "/" + name + "_screenshot.png");
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken: " + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot. Error: " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path) {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error:" + e.getMessage());
        }
        return bytes;
    }

}
