package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Update;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class SignupDao {
    private final Jdbi jdbi;

    public SignupDao() {
        // Sử dụng JDBIConnect.get() để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    public boolean register(String username, String password, String phone, String email) {
        String sql = "INSERT INTO `user` (roleID, name, password, phone, email) VALUES (0, :username, :password, :phone, :email);";
        try {
            String hashedPassword = md5Hash(password);
            int result = jdbi.withHandle(handle ->
                    handle.createUpdate(sql)
                            .bind("username", username)
                            .bind("password", hashedPassword)
                            .bind("phone", phone)
                            .bind("email", email)
                            .execute()
            );
            System.out.println("Số bản ghi được thêm: " + result);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        }
    }

    public User checkUser(String username) {
        String sql = "SELECT * FROM `user` WHERE name = :username";
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("username", username)
                        .map((rs, ctx) -> new User(
                                rs.getInt("id"),
                                rs.getInt("roleID"),
                                rs.getString("name"),
                                rs.getString("password")
                        ))
                        .findFirst()
                        .orElse(null)
        );
    }

    public String md5Hash(String input) {
        try {
            // Sử dụng thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            // Chuyển đổi mảng byte thành chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SignupDao dao = new SignupDao();
        System.out.println(dao.checkUser("ahihi"));
        System.out.println(dao.register("abdec", "123", "011111111", "cson5421117@gmail.com"));
    }
}
