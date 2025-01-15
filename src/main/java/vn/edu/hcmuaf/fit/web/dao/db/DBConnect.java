package vn.edu.hcmuaf.fit.web.dao.db;

//import java.sql.*;
//
//public class DBConnect {
//
//    public static Connection getConnection() {
//        Connection conn = null;
//
//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            String url = "jdbc:mysql://localhost:3306/apartment";
//            String username = "root";
//            String password = "";
//
//            conn = DriverManager.getConnection(url, username, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        return conn;
//
//    }
//
//    public static void main(String[] args) {
//        Connection conn = getConnection();
//        System.out.println(conn);
//    }
//}
import jakarta.servlet.http.HttpSession;

import java.sql.*;

public class DBConnect {
    public static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://" + DBProperties.host() + ":" + DBProperties.port() + "/" + DBProperties.dbname() + "?" + DBProperties.option();
                conn = DriverManager.getConnection(url, DBProperties.username(), DBProperties.password());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from apartment");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t" + rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


