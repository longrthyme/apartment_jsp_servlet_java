package vn.edu.hcmuaf.fit.web.dao.model;

public class ApartmentType {
    private int id;
    private String name;
    private int categoryID;

    public ApartmentType(int id, String name, int categoryID) {
        this.id = id;
        this.name = name;
        this.categoryID = categoryID;
    }
    public ApartmentType(){

    }

    public ApartmentType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApartmentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryID=" + categoryID +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
