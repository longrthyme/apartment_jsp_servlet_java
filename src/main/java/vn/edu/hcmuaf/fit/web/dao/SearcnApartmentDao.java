package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.util.List;

public class SearcnApartmentDao {
    private final Jdbi jdbi;

    public SearcnApartmentDao() {
        // Sử dụng JDBIConnect.get() để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    // Tìm kiếm căn hộ theo tên
    public List<Apartment> searchByName(String txtSearch) {
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
                "WHERE apartment.name LIKE :txtSearch";


        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .bind("txtSearch", "%" + txtSearch + "%") // Gán giá trị tham số LIKE
                        .mapToBean(Apartment.class) // Ánh xạ kết quả sang đối tượng Apartment
                        .list());
    }

    public static void main(String[] args) {
        SearcnApartmentDao dao = new SearcnApartmentDao();
        List<Apartment> list = dao.searchByName("B3");
        for(Apartment apartment : list) {
            System.out.println(apartment);
        }
    }
}
