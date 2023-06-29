package com.google.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    private Driver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Get browser from configuration.properties file
            String browser = ConfigurationReader.get("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                // Set the path to the chromedriver executable
                //System.setProperty("webdriver.chrome.driver", "//Users/emineer/Downloads/chromedriver");
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                // Set Chrome options if needed
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                // Create a new ChromeDriver instance
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("safari")) {
                // Create a new SafariDriver instance
                driver = new SafariDriver();
            }

            // Set implicit wait time
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}