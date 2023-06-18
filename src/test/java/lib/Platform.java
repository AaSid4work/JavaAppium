package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.bytebuddy.implementation.bytecode.assign.InstanceCheck;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {

        private static final String PLATFORM_IOS = "iOS";
        private static final String PLATFORM_ANDROID = "Android";
        private static final String APPIUM_URL = "http://127.0.0.1:4723/";
private static Platform Instance;
private Platform() {}
    public static Platform getInstance()
    {
        if(Instance == null){
            Instance = new Platform();
        }
        return Instance;
    }

        public AppiumDriver getDriver() throws Exception {
            URL URL = new URL(APPIUM_URL);
            if (this.isAndroid()) {
                return new AndroidDriver(URL, getAndroidDesiredCapabilities());
            } else if (this.isIOS()) {
                return new IOSDriver(URL, getiOSDesiredCapabilities());
            } else {
                throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
            }
        }
        public boolean isAndroid(){
            return isPlatform(PLATFORM_ANDROID);
        }
        public boolean isIOS() {
            return isPlatform(PLATFORM_IOS);
        }

    private DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 2");
        capabilities.setCapability("udid", "127.0.0.1:6555");
        capabilities.setCapability("platformVersion", "Android 10.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/anna.sidorova/Documents/JavaAppiumAutomation/apks/org.wikipedia.apk");
        return capabilities;

    }

    private DesiredCapabilities getiOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 14 Pro");
        capabilities.setCapability("udid", "160445E1-6043-4F9F-93F1-A3AB46CE4642");
        capabilities.setCapability("platformVersion", "16.2");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", "/Users/anna.sidorova/Library/Developer/Xcode/DerivedData/Wikipedia-hfcryophkiosfdbmywfftbhzysty/Build/Products/Debug-iphonesimulator/wiki.app");
        return capabilities;
    }

        private boolean isPlatform(String my_platform){
            String platform = this.getPlatformVar();
            return my_platform.equals(platform);
        }
        private String getPlatformVar() {
            return System.getenv("PLATFORM");
        }
    }

