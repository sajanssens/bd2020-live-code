package org.example.databases.jdbc;

import java.sql.*;

import static org.example.databases.jdbc.util.Props.get;

public class JdbcDemoExt {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(get("url"), get("username"), get("password"));
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            JdbcDemoExt jdbcDemo = new JdbcDemoExt();
            jdbcDemo.getAllRows(statement);
            jdbcDemo.insertTransactional(connection, statement);

            jdbcDemo.delete(connection, "1");
            // jdbcDemo.delete(connection, "2; drop table test; --");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void delete(Connection connection, String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM publishers where PUB_ID=?");
        preparedStatement.setString(1, id);

        int i = preparedStatement.executeUpdate();
        System.out.println("Deleted " + i + " rows.");
    }

    private void insertTransactional(Connection connection, Statement statement) {
        try {
            insert(connection, statement);
        } catch (SQLException e) {
            System.err.println("Er gaat iets mis in SQL..." + e.getMessage());
        }
    }

    private void insert(Connection connection, Statement statement) throws SQLException {
        try {
            connection.setAutoCommit(false);

            statement.executeUpdate("INSERT INTO publishers (pub_id, pub_name, city, state, country) VALUES ('8956', 'Test', 'Leusden', 'UT', 'NLD');");
            statement.executeUpdate("INSERT INTO publishers (pub_id, pub_name, city, state, country) VALUES ('008957', 'Test', 'Leusden', 'UT', 'NLD');");

            connection.commit();
        } catch (SQLException e) {
            System.err.println("Er gaat iets mis in SQL..." + e.getMessage());
            connection.rollback();
        }
    }

    public int getAllRows(Statement statement) throws SQLException {

        ResultSet resultSet = statement.executeQuery("select pub_id, pub_name, city, state from publishers");

        // 5a data
        while (resultSet.next()) {
            String pub_id = resultSet.getString(1);
            String pub_name = resultSet.getString(2);
            String city = resultSet.getString("city");

            System.out.println(pub_id + ", " + pub_name);
        }

        // 5b metadata
        ResultSetMetaData metaData = resultSet.getMetaData();
        String catalogName = metaData.getCatalogName(1);
        String schemaName = metaData.getSchemaName(1);
        System.out.println("catalogName=" + catalogName);
        System.out.println("schemaName=" + schemaName);

        resultSet.last();
        return resultSet.getRow();

    }

}
