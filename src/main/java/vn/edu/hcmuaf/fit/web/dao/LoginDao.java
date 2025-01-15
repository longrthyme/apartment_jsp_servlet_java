//package vn.edu.hcmuaf.fit.web.dao;
//
//import vn.edu.hcmuaf.fit.web.dao.db.DBConnect;
//import vn.edu.hcmuaf.fit.web.dao.model.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class LoginDao {
//
//    Connection conn = null;
//    PreparedStatement pre = null;
//    ResultSet rs = null;
//
//
//    public User login(String username, String password) {
//        String sql = "SELECT * FROM user WHERE name = ? AND password = ?;";
//        try {
//            conn = DBConnect.getConnection();
//            pre = conn.prepareStatement(sql);
//            pre.setString(1, username);
//            pre.setString(2, password);
//            rs = pre.executeQuery();
//            while (rs.next()) {
//                return new User(
//                        rs.getInt("id"),
//                        rs.getInt("roleID"),
//                        rs.getString("name"),
//                        rs.getString("password")
//                );
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    return null;
//    }
//
//    public static void main(String[] args) {
//        String username = "Nguyễn Chí Sơn";
//        String password = "111";
//        LoginDao dao = new LoginDao();
//
//        System.out.println(dao.login(username , password).toString());
//    }
//
//}
