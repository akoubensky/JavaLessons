package org.repositories;

import org.jdbc.Jdbc;
import org.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRepository {
    public static Country getCountry(String name) {
        Connection connection = Jdbc.INSTANCE.getConnection();
        if (connection == null) return null;
        try (PreparedStatement ps = connection.prepareStatement(
                "Select * From Countries Where name = ?")) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return null;
            return new Country(
                    rs.getString("name"),
                    rs.getString("capital"),
                    rs.getDouble("population"));
        } catch (SQLException e) {
            return null;
        }
    }
}
