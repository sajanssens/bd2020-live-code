package org.example.databases.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

import static org.example.databases.jdbc.util.Props.get;

public class JdbcDemo {

    // Simple Logging Facade For Java (SLF4J)
    Logger log = LoggerFactory.getLogger(JdbcDemo.class);

    public static void main(String[] args) {
        new JdbcDemo().run();
    }

    public void run() {
        try {
            // 1
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // SPI = plug and play

            // 2
            Connection connection = DriverManager.getConnection(get("url"), get("username"), get("password"));

            // 3
            Statement statement = connection.createStatement();

            // 4
            ResultSet resultSet = statement.executeQuery("select pub_id, pub_name, city, state from publishers");

            // 5a data
            while (resultSet.next()) {
                String pub_id = resultSet.getString(1);
                String pub_name = resultSet.getString(2);
                String city = resultSet.getString("city");

                log.debug(pub_id + ", " + pub_name + " @ " + city);
            }

            // 5b metadata
            ResultSetMetaData metaData = resultSet.getMetaData();
            String catalogName = metaData.getCatalogName(1);
            String schemaName = metaData.getSchemaName(1);
            log.debug("catalogName=" + catalogName);
            log.debug("schemaName=" + schemaName);

            // 6
            connection.close();

        } catch (SQLException e) {
            log.error("Er gaat iets mis in SQL..." + e.getMessage());
            log.debug("Exception!", e);
        }
    }

}
