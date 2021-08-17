import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        // Try to connect
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/test", "foo", "bar");

        System.out.println("It works!");

        connection.close();
    }
}
