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
