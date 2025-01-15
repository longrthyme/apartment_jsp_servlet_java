package vn.edu.hcmuaf.fit.web.dao.model;
public class User {
    private int id;
    private int roleID;
    private String name;
    private String password;
    private String email;
    private String phone;

    // No-argument constructor (required by JDBI)
    public User() {
    }

    // Full-argument constructor
    public User(int id, int roleID, String name, String password, String email, String phone) {
        this.id = id;
        this.roleID = roleID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    // Partial-argument constructor
    public User(int id, int roleID, String name, String password) {
        this.id = id;
        this.roleID = roleID;
        this.name = name;
        this.password = password;
    }

    // Getters and setters (required for JDBI mapping)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
