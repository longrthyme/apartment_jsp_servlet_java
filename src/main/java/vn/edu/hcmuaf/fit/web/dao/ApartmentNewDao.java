package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.web.dao.db.DBConnect;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Căn hộ mới đăng
public class ApartmentNewDao {

    private Jdbi jdbi;

    public ApartmentNewDao() {
        this.jdbi = JDBIConnect.get();
    }

    public List<Apartment> getAllProductsNew() {
        List<Apartment> list = new ArrayList<>();
        String sql = "SELECT \n" +
                "    apartment.id AS apartment_id, \n" +
                "    apartment.name, \n" +
                "    apartment.describe, \n" +
                "    apartment.price, \n" +
                "    apartment.area, \n" +
                "    apartment.bedroom, \n" +
                "    apartment.bathroom, \n" +
                "    apartment.toilet, \n" +
                "    apartment.interior, \n" +
                "    apartment.legal, \n" +
                "    apartment.posted_date, \n" +
                "    images.url, \n" +
                "    apartmentview.view_count, \n" +
                "    appartment_address.nameAddress \n" +  // Thêm trường nameAddress từ bảng appartment_address
                "FROM \n" +
                "    images \n" +
                "INNER JOIN (apartment \n" +
                "    INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID \n" +
                "    INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID) \n" + // Kết nối với bảng appartment_address
                "ON images.apartmentID = apartment.ID \n" +
                "ORDER BY \n" +
                "    apartment.ID DESC;";


        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .mapToBean(Apartment.class) // Tự động ánh xạ kết quả vào lớp Apartment
                        .list()
        );
    }

    public static void main(String[] args) {
        ApartmentNewDao dao = new ApartmentNewDao();
        List<Apartment> list = dao.getAllProductsNew();
        for (Apartment product : list) {
            System.out.println(product.toString());
        }
    }
}
