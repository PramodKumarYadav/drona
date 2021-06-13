package com.saucedemo.pages;

import com.saucedemo.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.DriverManagerType.OPERA;

public class DriverFactory {
    private static WebDriver driver;
    private static Config config = new Config();
    private static String browser;

    public static WebDriver getDriver() {
        browser = config.getBrowser();

        switch (browser) {

            case "firefox":
                WebDriverManager.getInstance(FIREFOX).setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.getInstance(EDGE).setup();
                driver = new EdgeDriver();

            case "opera":
                WebDriverManager.getInstance(OPERA).setup();
                driver = new OperaDriver();

            default:
                WebDriverManager.getInstance(CHROME).setup();
                driver = new ChromeDriver();
        }
        return driver;
    }
}

