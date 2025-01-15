package vn.edu.hcmuaf.fit.web.dao.model;

public class User {
    private int id;
    private int roleID;
    private String name;
    private String password;
    private String email;
    private String phone;

    public User(int id, int roleID, String name, String password, String email, String phone) {
        this.id = id;
        this.roleID = roleID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(int id, int roleID, String name, String password) {
        this.id = id;
        this.roleID = roleID;
        this.name = name;
        this.password = password;

    }




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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleID=" + roleID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}