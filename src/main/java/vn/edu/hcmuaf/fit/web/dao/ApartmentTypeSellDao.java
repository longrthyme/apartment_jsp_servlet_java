package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.ApartmentType;

import java.util.List;

// category căn hộ bán
public class ApartmentTypeSellDao {
    private Jdbi jdbi;

    public ApartmentTypeSellDao() {
        // Sử dụng JDBIConnect để tái sử dụng kết nối
        this.jdbi = JDBIConnect.get();
    }

    public List<ApartmentType> getDetailCategory() {
        String sql = "SELECT * FROM apartmenttype WHERE categoryId = 1";

        // Sử dụng JDBI để thực hiện truy vấn và ánh xạ kết quả
        return jdbi.withHandle(handle ->
                handle.createQuery(sql)
                        .mapToBean(ApartmentType.class) // Ánh xạ kết quả vào lớp ApartmentType
                        .list()
        );
    }

    public static void main(String[] args) {
        ApartmentTypeSellDao dao = new ApartmentTypeSellDao();
        List<ApartmentType> list = dao.getDetailCategory();
        for (ApartmentType a : list) {
            System.out.println(a.toString());
        }
    }
}
