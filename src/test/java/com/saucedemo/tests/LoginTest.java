package com.saucedemo.tests;

import com.saucedemo.pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    WebDriver driver;
    com.saucedemo.pages.Login Login;

    @BeforeEach
    public void setup() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        String appURL = "https://www.saucedemo.com/";
        driver.get(appURL);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvSource({"standard_user,secret_sauce",
            "problem_user,secret_sauce"
    })

    public void assertThatAValidUserCanLogin(String username, String password) {
        Login = new Login(driver);
        Login.login(username, password);
        String pageTitle = Login.getLoginTitle();
        assertEquals(pageTitle, "Products");
    }

    @Test
    public void assertThatALockedOutUserCanNotLogIn() {
        Login = new Login(driver);
        Login.login("locked_out_user", "secret_sauce");
        String loginError = Login.getLoginLockOutError();
        assertEquals(loginError, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void assertThatAPerformanceIssueUserCanLogInButAfterSomeDelays() {
        Login = new Login(driver);
        Login.login("performance_glitch_user", "secret_sauce");
        String pageTitle = Login.getLoginTitle();
        assertEquals(pageTitle, "Products");
    }
}
