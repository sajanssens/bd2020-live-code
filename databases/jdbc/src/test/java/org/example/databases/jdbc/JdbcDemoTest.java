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
        Connection connection = DriverManager.getConnection(get("url"), get("username"), get("password"));

        // 3
        Statement statement = connection.createStatement();
        statement.execute("create table PUBLISHERS \n" +
                "(\n" +
                "\tPUB_ID varchar(4) not null,\n" +
                "\tcity varchar(255) null,\n" +
                "\tcountry varchar(255) null,\n" +
                "\tPUB_NAME varchar(255) null,\n" +
                "\tstate varchar(2) null, \n" +
                "\t primary key (PUB_ID)" +
                ");");

        statement.executeUpdate("INSERT INTO publishers (pub_id, pub_name, city, state, country) VALUES (N'0736', N'New Moon Books', N'Boston', N'MA', N'USA');");

        // connection.close(); // this destroys the in mem db..?
    }

    @Test
    void run() throws SQLException {
        target.run();
    }

}
