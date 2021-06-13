package com.saucedemo.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class DriverFactory {
    private static WebDriver driver;
    private static String browser = "chrome";

    public static WebDriver getDriver() {
        switch (browser) {
            case "chrome":
                WebDriverManager.getInstance(CHROME).setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.getInstance(FIREFOX).setup();
                driver = new FirefoxDriver();
                break;

            default:
                WebDriverManager.getInstance(CHROME).setup();
                driver = new ChromeDriver();
        }
        return driver;
    }
}

