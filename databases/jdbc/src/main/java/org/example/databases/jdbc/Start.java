package org.example.databases.jdbc;

import java.sql.*;

public class Start {

    public static void main(String[] args) {

        try {
            // 1
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // SPI = plug and play

            // 2
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pubs", "root", "root");

            // 3
            Statement statement = connection.createStatement();

            // 4
            ResultSet resultSet = statement.executeQuery("select pub_id, pub_name, city, state from publishers");

            // 5
            while (resultSet.next()) {
                String pub_id = resultSet.getString(1);
                String pub_name = resultSet.getString(2);

                System.out.println(pub_id + ", " + pub_name);
            }

            // 6
            connection.close();

            // } catch (ClassNotFoundException e) {
            //     System.err.println("Driver kon niet worden gevonden... Neem contact op..");
        } catch (SQLException e) {
            System.err.println("Er gaat iets mis met SQL..." + e.getMessage());
        }
    }

}
