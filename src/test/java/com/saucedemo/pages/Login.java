package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
    WebDriver driver;

    @FindBy(name = "user-name")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "login-button")
    WebElement login;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement lockOutError;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String user) {
        username.sendKeys(user);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        login.click();
    }

    public String getLoginTitle() {
        return title.getAttribute("innerHTML");
    }

    public String getLoginLockOutError() {
        return lockOutError.getText();
    }

    public void login(String UserValue, String PasswordValue) {
        
        driver.get("https://www.saucedemo.com/");
        this.setUsername(UserValue);
        this.setPassword(PasswordValue);
        this.clickLogin();
    }

}

