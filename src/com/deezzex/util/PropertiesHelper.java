/**
 * @author deezzex <3
 */


package com.deezzex.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.Properties;

@UtilityClass
public class PropertiesHelper {

    private final static Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties(){
        try (var propertiesStream = PropertiesHelper.class
                .getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(propertiesStream);
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }
}
