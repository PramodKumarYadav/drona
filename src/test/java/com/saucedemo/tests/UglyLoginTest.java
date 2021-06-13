package com.saucedemo.tests;

import com.saucedemo.pages.DriverFactory;
import com.saucedemo.pages.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UglyLoginTest {
    private Login login;
    private WebDriver driver;

    @BeforeEach
    public void setup() {

        driver = DriverFactory.getDriver();
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
        assertEquals("Products", login.getTitle());
    }

    @Test
    public void assertThatALockedOutUserCanNotLogIn() {
        login.login("locked_out_user", "secret_sauce");
        assertEquals("Epic sadface: Sorry, this user has been locked out.", login.getLoginLockOutError());
    }

    @Test
    public void assertThatAPerformanceIssueUserCanLogInButAfterSomeDelays() {
        login.login("performance_glitch_user", "secret_sauce");
        assertEquals("Products", login.getTitle());
    }
}
