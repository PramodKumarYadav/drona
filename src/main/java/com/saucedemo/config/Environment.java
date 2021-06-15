package com.saucedemo.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface Environment extends Config {


    String url();
    String username();
    String password();
    String browser();

}

