package com.epam.lab.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AppiumDriver driver;

    private Driver() {
    }

    public static void createDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "/src/main/resources");
            File app = new File(appDir, "browser.apk");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Testing Phone");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appPackage", "com.android.chrome");
            capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver(url, capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            if (getDriver() != null) {
                getDriver().quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
