package org.jdbc;

import lombok.Getter;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Jdbc {
    public static final Jdbc INSTANCE = new Jdbc();

    @Getter
    private Connection connection;

    private Jdbc() {
        try {
            Properties p = new Properties();
            p.load(Jdbc.class.getClassLoader().getResourceAsStream("h2.properties"));
            connection = DriverManager.getConnection(
                    p.getProperty("h2.countries.url"),
                    p.getProperty("h2.countries.username"),
                    p.getProperty("h2.countries.password"));
        } catch (SQLException | IOException e) {
            connection = null;
        }
    }
}
