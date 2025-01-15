package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.util.List;

public class ApartmentFilterDao {
    private Jdbi jdbi;

    public ApartmentFilterDao() {
        // Sử dụng JDBIConnect để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    // Lấy danh sách căn hộ bán
    public List<Apartment> getAllProductsFilterSell(String id) {
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
                "    INNER JOIN category ON apartment.categoryID = category.ID \n" +
                "    INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID \n" +
                "    INNER JOIN apartmenttype ON apartment.typeID = apartmenttype.ID \n" +
                "    INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID) \n" + // Kết nối với bảng appartment_address
                "ON \n" +
                "    images.apartmentID = apartment.ID \n" +
                "WHERE \n" +
                "    apartmenttype.ID = :id AND category.ID = 1;";


        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("id", id) // Truyền tham số id
                        .mapToBean(Apartment.class) // Ánh xạ kết quả vào lớp Apartment
                        .list()
        );
    }

    // Lấy danh sách căn hộ thuê
    public List<Apartment> getAllProductsFilterRent(String id) {
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
                "    INNER JOIN category ON apartment.categoryID = category.ID \n" +
                "    INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID \n" +
                "    INNER JOIN apartmenttype ON apartment.typeID = apartmenttype.ID \n" +
                "    INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID) \n" + // Kết nối với bảng appartment_address
                "ON \n" +
                "    images.apartmentID = apartment.ID \n" +
                "WHERE \n" +
                "    apartmenttype.ID = :id AND category.ID = 2;";


        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("id", id) // Truyền tham số id
                        .mapToBean(Apartment.class) // Ánh xạ kết quả vào lớp Apartment
                        .list()
        );
    }

    public static void main(String[] args) {
        ApartmentFilterDao dao = new ApartmentFilterDao();

        // Lấy danh sách căn hộ bán
        List<Apartment> sellList = dao.getAllProductsFilterSell("1");
        System.out.println("Căn hộ bán:");
        sellList.forEach(System.out::println);

        // Lấy danh sách căn hộ thuê
        List<Apartment> rentList = dao.getAllProductsFilterRent("1");
        System.out.println("Căn hộ thuê:");
        rentList.forEach(System.out::println);
    }
}
