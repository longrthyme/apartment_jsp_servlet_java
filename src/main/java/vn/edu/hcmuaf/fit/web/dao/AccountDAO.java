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
   


    
}
