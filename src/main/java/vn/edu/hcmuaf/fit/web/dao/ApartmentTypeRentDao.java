package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.ApartmentType;

import java.util.List;

// category căn hộ thuê
public class ApartmentTypeRentDao {
    private Jdbi jdbi;

    public ApartmentTypeRentDao() {
        // Sử dụng JDBIConnect để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    public List<ApartmentType> getDetailCategory() {
        String sql = "SELECT * FROM apartmenttype WHERE categoryId = 2";

        // Sử dụng JDBI để thực hiện truy vấn và ánh xạ kết quả
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .mapToBean(ApartmentType.class) // Ánh xạ kết quả vào lớp ApartmentType
                        .list()
        );
    }

    public static void main(String[] args) {
        ApartmentTypeRentDao dao = new ApartmentTypeRentDao();
        List<ApartmentType> list = dao.getDetailCategory();
        for (ApartmentType a : list) {
            System.out.println(a.toString());
        }
    }
}
