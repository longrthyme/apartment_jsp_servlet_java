package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.util.List;

public class ApartmentDao {

    private Jdbi jdbi;

    public ApartmentDao() {
        // Sử dụng JDBIConnect.get() để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    public List<Apartment> getAllProductsSell() {
        String sql = "SELECT apartment.id AS apartment_id, apartment.name, apartment.describe, apartment.price, apartment.area, apartment.bedroom, apartment.bathroom, apartment.toilet, apartment.interior, apartment.legal, apartment.posted_date, images.URL, apartmentview.view_count , appartment_address.nameAddress\n" +
                "FROM images \n" +
                "INNER JOIN apartment ON images.apartmentID = apartment.ID \n" +
                "INNER JOIN category ON apartment.categoryID = category.ID \n" +
                "INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID \n" +
                "INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID \n" +
                "WHERE category.ID = 1 ";  // Căn hộ bán


        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .mapToBean(Apartment.class)
                        .list()
        );
    }

    public List<Apartment> getAllApartments() {
        String sql = "SELECT apartment.id, apartment.name, apartment.describe, apartment.price, apartment.area, " +
                 "apartment.bedroom, apartment.bathroom, apartment.toilet, apartment.interior, apartment.legal, " +
                 "apartment.posted_date, images.URL AS url, apartmentview.view_count AS viewCount, " +
                 "appartment_address.nameAddress " +
                 "FROM images " +
                 "INNER JOIN apartment ON images.apartmentID = apartment.ID " +
                 "INNER JOIN category ON apartment.categoryID = category.ID " +
                 "INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID " +
                 "INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID ";
                //  "WHERE category.ID = 1";   // Assuming category ID 1 is for "selling apartments"
    
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                      .mapToBean(Apartment.class)
                      .list()
        );
    }


    public Apartment getApartmentById(int id) {
        String sql = "SELECT apartment.id, apartment.name, apartment.describe, apartment.price, apartment.area, " +
                     "apartment.bedroom, apartment.bathroom, apartment.toilet, apartment.interior, apartment.legal, " +
                     "apartment.posted_date, images.URL AS url, apartmentview.view_count AS viewCount, " +
                     "appartment_address.nameAddress " +
                     "FROM images " +
                     "INNER JOIN apartment ON images.apartmentID = apartment.ID " +
                     "INNER JOIN category ON apartment.categoryID = category.ID " +
                     "INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID " +
                     "INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID " +
                     "WHERE apartment.id = :id";  // using named parameter for apartment ID
    
        

                     Apartment apartment = jdbi.withHandle(handle ->
        handle.createQuery(sql)
              .bind("id", id)  // bind the 'id' parameter to the query
              .mapToBean(Apartment.class)
              .findOnly()  // retrieves a single result, throws an exception if not found
    );
    
    return apartment;  // If apartment is not found, it will return null


    }
    


    public boolean updateApartment(Apartment apartment) {
        String sql = "UPDATE apartment " +
        "SET name = :name, " +
        "    `describe` = :describe, " + // Enclosed describe in backticks
        "    price = :price, " +
        "    area = :area, " +
        "    bedroom = :bedroom, " +
        "    bathroom = :bathroom, " +
        "    toilet = :toilet, " +
        "    interior = :interior, " +
        "    legal = :legal, " +
        "    posted_date = :postedDate, " +
        "    addressID = (SELECT ID FROM appartment_address WHERE nameAddress = :nameAddress) " +
        "WHERE id = :id";
        
        try {
            int rowsAffected = jdbi.withHandle(handle ->
                handle.createUpdate(sql)
                      .bind("id", apartment.getId())
                      .bind("name", apartment.getName())
                      .bind("describe", apartment.getDescribe())
                      .bind("price", apartment.getPrice())
                      .bind("area", apartment.getArea())
                      .bind("bedroom", apartment.getBedroom())
                      .bind("bathroom", apartment.getBathroom())
                      .bind("toilet", apartment.getToilet())
                      .bind("interior", apartment.getInterior())
                      .bind("legal", apartment.getLegal())
                      .bind("postedDate", apartment.getPostedDate())
                      .bind("nameAddress", apartment.getNameAddress())
                      .execute()
            );
            return rowsAffected > 0; // Return true if at least one row was updated
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if an exception occurs
        }
    }


    

    public List<Apartment> getAllProductsRent() {
        String sql = "SELECT apartment.id AS apartment_id, apartment.name, apartment.describe, apartment.price, apartment.area, apartment.bedroom, apartment.bathroom, apartment.toilet, apartment.interior, apartment.legal, apartment.posted_date, images.URL, apartmentview.view_count , appartment_address.nameAddress\n" +
                "FROM images \n" +
                "INNER JOIN apartment ON images.apartmentID = apartment.ID \n" +
                "INNER JOIN category ON apartment.categoryID = category.ID \n" +
                "INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID \n" +
                "INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID \n" +
                "WHERE category.ID = 2 ";


        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .mapToBean(Apartment.class)
                        .list()
        );
    }

    public static void main(String[] args) {
        ApartmentDao dao = new ApartmentDao();

        // Lấy danh sách căn hộ bán
        List<Apartment> list = dao.getAllProductsSell();
        for (Apartment product : list) {
            System.out.println(product.toString());
        }

        System.out.println("Căn hộ bán--------------------------------------------------------------------------------");

        // Lấy danh sách căn hộ cho thuê
        List<Apartment> list1 = dao.getAllProductsRent();
        for (Apartment product : list1) {
            System.out.println(product.toString());
        }
    }
}
