package org.example.databases.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcDemoExtRefactored {

    private final Logger log = LoggerFactory.getLogger(JdbcDemoExtRefactored.class);

    public static void main(String[] args) {
        new JdbcDemoExtRefactored().start();
    }

    private void start() {

        PublisherDao dao = new PublisherDao();

        dao.findAll().forEach(p -> log.debug(p.toString()));

        // jdbcDemo.insertTransactional(connection, statement);
        // jdbcDemo.delete(connection, "1");
        //
        // // sql injection....:
        // statement.execute("create table test(id int)");
        // jdbcDemo.delete(statement, "2; drop table test; --");

    }

}
