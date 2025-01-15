package vn.edu.hcmuaf.fit.web.dao;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.User;

public class AccountDAO {

    private Jdbi jdbi;
    
    public AccountDAO() {
        this.jdbi = JDBIConnect.get();
    }

    public List<User> getUsersByRoleID(Integer id) {
        String sql = "SELECT id, roleID, name, password, email, phone FROM user WHERE roleID = :id";

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("id", id)  // Bind the 'id' parameter to the query
                        .mapToBean(User.class)  // Map the result set to User objects
                        .list()  // Return the list of users
        );
    
    }


    public void insertUser(User user) {
        String sql = "INSERT INTO user (roleID, name, password, email, phone) VALUES (:roleID, :name, :password, :email, :phone)";
    
        jdbi.useHandle(handle ->
            handle.createUpdate(sql)
                  .bind("roleID", user.getRoleID())
                  .bind("name", user.getName())
                  .bind("password", user.getPassword())
                  .bind("email", user.getEmail())
                  .bind("phone", user.getPhone())
                  .execute()
        );
    }
    


    public void deleteAccount(int id) {
        String sql = "DELETE FROM user WHERE id = :id";
        try {
            jdbi.useHandle(handle ->
                handle.createUpdate(sql)
                      .bind("id", id)
                      .execute()
            );
            System.out.println("Account with ID " + id + " deleted successfully.");
        } catch (Exception e) {
            System.err.println("Failed to delete account with ID " + id + ": " + e.getMessage());
            throw new RuntimeException("Error deleting account. Please try again later.", e);
        }
    }


    public User getAccountById(Integer id) {
        String sql = "SELECT id, roleID, name, password, email, phone FROM user WHERE id = :id";

        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                      .bind("id", id)  // Bind the 'id' parameter to the query
                      .mapToBean(User.class)  // Map the result set to a User object
                      .findOne()  // Return an Optional<User>
                      .orElse(null)  // Return null if no user is found
        );
    }
   

    public void updateUser(User user) {
        String sql = "UPDATE user SET name = :name, roleID = :roleID, email = :email, password = :password, phone = :phone WHERE id = :id";
    
        jdbi.useHandle(handle -> 
            handle.createUpdate(sql)
                  .bind("id", user.getId())
                  .bind("name", user.getName())
                  .bind("roleID", user.getRoleID())
                  .bind("email", user.getEmail())
                  .bind("password", user.getPassword())
                  .bind("phone", user.getPhone())
                  .execute()
        );
    }
    
}
