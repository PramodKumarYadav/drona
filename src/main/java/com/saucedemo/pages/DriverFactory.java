package com.saucedemo.pages;

import com.saucedemo.config.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class DriverFactory {
    private static WebDriver driver;
    static Environment environment;
    public static WebDriver getDriver() {
        environment = ConfigFactory.create(Environment.class,System.getenv(), System.getProperties());
        switch (environment.browser()) {
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

    public static void setEnvironment(Environment environment) {
        DriverFactory.environment = environment;
    }
}

