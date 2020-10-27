package org.example.databases.jdbc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.databases.jdbc.util.Props.get;

class JdbcDemoTest {

    private final JdbcDemo target = new JdbcDemo();

    @BeforeAll static void setUp() throws SQLException {
        String serverTimezone = get("serverTimezone");
        String username = get("username");
        String password = get("password");

        Connection connection = DriverManager.getConnection(get("url") + get("database") + "?" + "serverTimezone=" + serverTimezone, username, password);
        // 3
        Statement statement = connection.createStatement();
        statement.execute("CREATE SCHEMA IF NOT EXISTS pubs");
        statement.execute("create table if not exists publishers\n" +
                "(\n" +
                "\tPUB_ID varchar(4) not null\n" +
                "\t\tprimary key,\n" +
                "\tcity varchar(255) null,\n" +
                "\tcountry varchar(255) null,\n" +
                "\tPUB_NAME varchar(255) null,\n" +
                "\tstate varchar(2) null\n" +
                ")\n" +
                "charset=latin1;\n" +
                "\n");

        connection.close();
    }

    @Test
    void run() {
        target.run();
    }
}
