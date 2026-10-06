import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcInsertExample {

    public static void main(String[] args) {

        // Database details
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "your_password";

        // SQL query
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Set values
            ps.setInt(1, 101);
            ps.setString(2, "Rahul");
            ps.setInt(3, 20);

            // Execute insert
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record inserted successfully!");
            }

            // Close resources
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

Database setup

First, create the database and table in MySQL:

CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

How it works

DriverManager.getConnection() connects Java to MySQL.

PreparedStatement prepares the INSERT query.

setInt() and setString() supply the values.

executeUpdate() executes the INSERT statement.

The connection and statement are closed after the operation.

You also need the MySQL JDBC driver (mysql-connector-j) in your project's classpath.
