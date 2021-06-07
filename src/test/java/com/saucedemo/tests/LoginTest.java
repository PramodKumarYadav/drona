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
    com.saucedemo.pages.Login login;

    @BeforeEach
    public void setup() {
        WebDriverManager.getInstance(CHROME).setup();

        driver = new ChromeDriver();
        login = new Login(driver);
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
        login.login(username, password);
        assertEquals(login.getLoginTitle(), "Products");
    }

    @Test
    public void assertThatALockedOutUserCanNotLogIn() {
        login.login("locked_out_user", "secret_sauce");
        assertEquals(login.getLoginLockOutError(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void assertThatAPerformanceIssueUserCanLogInButAfterSomeDelays() {
        login.login("performance_glitch_user", "secret_sauce");
        assertEquals(login.getLoginTitle(), "Products");
    }
}
