package com.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader{

    private Properties properties;
    private final String configFilePath = "Configurations//config.properties";

    public ConfigFileReader(){

        try{
        FileReader reader = new FileReader(configFilePath);
        properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + configFilePath);
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        return browser;
    }
}
