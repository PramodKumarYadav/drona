package com.saucedemo.config;

public class Config {

    private String browser;

    public Config(){
        browser = System.getProperty("browser","chrome");
    }

    public String getBrowser() {
        return browser;
    }
}
