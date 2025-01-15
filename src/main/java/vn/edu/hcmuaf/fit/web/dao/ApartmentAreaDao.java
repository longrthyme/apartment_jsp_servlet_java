package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.util.List;

public class ApartmentAreaDao {
    private Jdbi jdbi;

    public ApartmentAreaDao() {
        // Sử dụng JDBIConnect.get() để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    public List<Apartment> getApartmentByArea(String area) {
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
                "    apartmentview.view_count,\n" +
                "    appartment_address.nameAddress  -- Tên bảng đúng là appartment_address\n" +
                "FROM \n" +
                "    images \n" +
                "INNER JOIN \n" +
                "    apartment \n" +
                "ON \n" +
                "    images.apartmentID = apartment.ID \n" +
                "INNER JOIN \n" +
                "    apartmentview \n" +
                "ON \n" +
                "    apartment.ID = apartmentview.apartmentID \n" +
                "INNER JOIN \n" +
                "    appartment_address  -- Bảng đúng của bạn là appartment_address\n" +
                "ON \n" +
                "    apartment.addressID = appartment_address.ID\n" +
                "WHERE \n" +
                "    appartment_address.nameAddress LIKE :area";

        // Thực hiện truy vấn bằng JDBI
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("area", "%" + area + "%") // Truyền tham số area
                        .mapToBean(Apartment.class)    // Ánh xạ kết quả vào lớp Apartment
                        .list()
        );
    }

    public static void main(String[] args) {
        ApartmentAreaDao dao = new ApartmentAreaDao();
        List<Apartment> list = dao.getApartmentByArea("TP.Hồ Chí Minh");
        for (Apartment a : list) {
            System.out.println(a.toString());
        }
    }
}
