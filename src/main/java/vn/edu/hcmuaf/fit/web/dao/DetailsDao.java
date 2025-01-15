package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.util.List;

public class DetailsDao {

    private Jdbi jdbi;

    public DetailsDao() {
        // Sử dụng JDBIConnect.get() để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    public List<Apartment> getDetailsApartment(String aid) {
        String sql = "SELECT " +
                "    apartment.id AS apartment_id, " +
                "    apartment.name, " +
                "    apartment.describe, " +
                "    apartment.price, " +
                "    apartment.area, " +
                "    apartment.bedroom, " +
                "    apartment.bathroom, " +
                "    apartment.toilet, " +
                "    apartment.interior, " +
                "    apartment.legal, " +
                "    apartment.posted_date, " +
                "    images.url, " +
                "    apartmentview.view_count, " +
                "    appartment_address.nameAddress " + // Thêm trường nameAddress từ bảng appartment_address
                "FROM images " +
                "INNER JOIN apartment ON images.apartmentID = apartment.ID " +
                "INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID " +
                "INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID " + // Kết nối với bảng appartment_address
                "WHERE apartment.ID = :aid;";


        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("aid", aid)
                .registerRowMapper(BeanMapper.factory(Apartment.class))
                .mapTo(Apartment.class)
                .list());
    }

    public static void main(String[] args) {

        DetailsDao dao = new DetailsDao();
        List<Apartment> list = dao.getDetailsApartment("1");
        for (Apartment apartment : list) {
            System.out.println(apartment);
        }
    }
}