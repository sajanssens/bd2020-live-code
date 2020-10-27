package org.example.databases.jdbc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.example.databases.jdbc.util.Props.get;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PublisherDaoTest {

    private final PublisherDao target = new PublisherDao();

    @BeforeAll
    static void setUp() throws SQLException {
        Connection connection = DriverManager.getConnection(get("url"), get("username"), get("password"));

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

        statement.executeUpdate("INSERT INTO publishers (pub_id, pub_name, city, state, country) VALUES ('1', 'New Moon Books', 'Boston', 'MA', 'USA');");
        statement.executeUpdate("INSERT INTO publishers (pub_id, pub_name, city, state, country) VALUES ('2', 'New Moon Books', 'Boston', 'MA', 'USA');");

        // connection.close(); // don't close: this destroys the in mem db
    }

    @Test
    void run() {
        List<Publisher> all = target.findAll();
        assertThat(all.size(), is(2));
    }

}
