package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    @FindBy(name = "user-name")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login-button")
    private WebElement login;

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement lockOutError;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void setUsername(String user) {
        username.sendKeys(user);
    }

    private void setPassword(String password) {
        this.password.sendKeys(password);
    }

    private void clickLogin() {
        login.click();
    }

    public String getTitle() {
        return title.getAttribute("innerHTML");
    }

    public String getLoginLockOutError() {
        return lockOutError.getText();
    }

    public void login(String user, String password) {
        driver.get("https://www.saucedemo.com/");
        setUsername(user);
        setPassword(password);
        clickLogin();
    }
}

