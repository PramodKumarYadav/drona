package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SauceDemoLogin {
    WebDriver driver;
    @FindBy(name = "user-name")
    WebElement Username;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(name = "login-button")
    WebElement Login;
    @FindBy(className = "title")
    WebElement title;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement LockOutError;

    public SauceDemoLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String UserValue) {
        Username.sendKeys(UserValue);
    }

    public void enterPassword(String PasswordValue) {

        Password.sendKeys(PasswordValue);
    }

    public void clickLogin() {

        Login.click();
    }

    public String getLoginTitle() {
        return title.getAttribute("innerHTML");
    }

    public String getLoginLockOutError() {
        return LockOutError.getText();
    }

    public void loginToSauceDemo(String UserValue, String PasswordValue) {
        this.enterUsername(UserValue);
        this.enterPassword(PasswordValue);
        this.clickLogin();
    }

}

