/**
 * @author deezzex <3
 */


package com.deezzex.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.deezzex.util.PropertiesHelper.getProperty;

@UtilityClass
public  class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static final String DRIVER_KEY = "db.driver";

    static {
        loadDriver();
    }

    @SneakyThrows
    private static void loadDriver() {
        Class.forName(getProperty(DRIVER_KEY));
    }

    @SneakyThrows
    public static Connection getConnection(){
        return DriverManager.getConnection(
                getProperty(URL_KEY),
                getProperty(USER_KEY),
                getProperty(PASSWORD_KEY)
        );
    }
}
