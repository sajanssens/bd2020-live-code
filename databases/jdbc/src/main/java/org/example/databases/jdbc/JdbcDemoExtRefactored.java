package org.example.databases.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcDemoExtRefactored {

    private final Logger log = LoggerFactory.getLogger(JdbcDemoExtRefactored.class);
    private final PublisherDao dao = new PublisherDao();

    public static void main(String[] args) {
        new JdbcDemoExtRefactored().start();
    }

    private void start() {
        dao.findAll().forEach(p -> log.debug(p.toString()));
    }

}
