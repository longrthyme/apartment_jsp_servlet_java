package vn.edu.hcmuaf.fit.web.dao;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import vn.edu.hcmuaf.fit.web.dao.db.JDBIConnect;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.util.List;

public class SearchDao {

    private final Jdbi jdbi;

    public SearchDao() {
        this.jdbi = JDBIConnect.get();
        this.jdbi.registerRowMapper(BeanMapper.factory(Apartment.class));
    }

    public List<Apartment> searchApartments(String txtSearch, String city, String type, String price, String area, String bedroom) {
        StringBuilder sql = new StringBuilder(
                "SELECT " +
                        "    apartment.id AS id, " +
                        "    apartment.name, " +
                        "    apartment.describe, " +
                        "    apartment.price, " +
                        "    apartment.area, " +
                        "    apartment.bedroom, " +
                        "    apartment.bathroom, " +
                        "    apartment.toilet, " +
                        "    apartment.interior, " +
                        "    apartment.legal, " +
                        "    apartment.posted_date AS postedDate, " +
                        "    images.url, " +
                        "    apartmentview.view_count AS viewCount, " +
                        "    appartment_address.nameAddress AS nameAddress " + // Thêm appartment_address.nameAddress
                        "FROM images " +
                        "INNER JOIN apartment ON images.apartmentID = apartment.ID " +
                        "INNER JOIN apartmenttype ON apartment.typeID = apartmenttype.ID " +
                        "INNER JOIN apartmentview ON apartment.ID = apartmentview.apartmentID " +
                        "INNER JOIN appartment_address ON apartment.addressID = appartment_address.ID " + // Thêm INNER JOIN appartment_address
                        "WHERE 1=1 "
        );

        // Thêm điều kiện động vào câu SQL
        if (txtSearch != null && !txtSearch.trim().isEmpty()) {
            sql.append(" AND apartment.name LIKE :txtSearch");
        }
        if (city != null && !city.trim().isEmpty()) {
            sql.append(" AND appartment_address.nameAddress LIKE :city"); // Sửa lại từ apartment.city thành appartment_address.nameAddress
        }

        if (type != null && !type.trim().isEmpty()) {
            sql.append(" AND apartmenttype.name = :type");
        }
        if (price != null && !price.trim().isEmpty()) {
            sql.append(" AND apartment.price BETWEEN :priceStart AND :priceEnd");
        }
        if (area != null && !area.trim().isEmpty()) {
            sql.append(" AND apartment.area BETWEEN :areaStart AND :areaEnd");
        }
        if (bedroom != null && !bedroom.trim().isEmpty()) {
            sql.append(" AND apartment.bedroom = :bedroom");
        }

        return jdbi.withHandle(handle -> {
            var query = handle.createQuery(sql.toString());

            // Gán tham số cho câu truy vấn
            if (txtSearch != null && !txtSearch.trim().isEmpty()) {
                query.bind("txtSearch", "%" + txtSearch.trim() + "%");
            }
            if (city != null && !city.trim().isEmpty()) {
                query.bind("city","%" +  city.trim() + "%");
            }
            if (type != null && !type.trim().isEmpty()) {
                query.bind("type", type.trim());
            }
            if (price != null && !price.trim().isEmpty()) {
                String[] priceRange = parsePrice(price.trim());
                query.bind("priceStart", Double.parseDouble(priceRange[0]))
                        .bind("priceEnd", Double.parseDouble(priceRange[1]));
            }
            if (area != null && !area.trim().isEmpty()) {
                String[] areaRange = parseArea(area.trim());
                query.bind("areaStart", Double.parseDouble(areaRange[0]))
                        .bind("areaEnd", Double.parseDouble(areaRange[1]));
            }
            if (bedroom != null && !bedroom.trim().isEmpty()) {
                query.bind("bedroom", Integer.parseInt(bedroom.trim()));
            }

            // Thực thi và trả về danh sách kết quả
            return query.mapTo(Apartment.class).list();
        });
    }

    private String[] parsePrice(String price) {
        switch (price.toLowerCase()) {
            case "dưới 500 triệu":
                return new String[]{"0", "500000000"};
            case "500-800 triệu":
                return new String[]{"500000000", "800000000"};
            case "dưới 1 tỷ":
                return new String[]{"0", "1000000000"};
            case "1-2 tỷ":
                return new String[]{"1000000000", "2000000000"};
            case "3-5 tỷ":
                return new String[]{"3000000000", "5000000000"};
            case "5-10 tỷ":
                return new String[]{"5000000000", "10000000000"};
            default:
                return new String[]{"0", String.valueOf(Long.MAX_VALUE)};
        }
    }

    private String[] parseArea(String area) {
        switch (area.toLowerCase()) {
            case "dưới 50 m²":
                return new String[]{"0", "50"};
            case "50-100 m²":
                return new String[]{"50", "100"};
            case "100-150 m²":
                return new String[]{"100", "150"};
            case "150-200 m²":
                return new String[]{"150", "200"};
            case "200+ m²":
                return new String[]{"200", String.valueOf(Double.MAX_VALUE)};
            default:
                return new String[]{"0", String.valueOf(Double.MAX_VALUE)};
        }
    }

    public static void main(String[] args) {
        SearchDao dao = new SearchDao();
        List<Apartment> apartments = dao.searchApartments("B3", "", "", "", "", "");
        apartments.forEach(System.out::println);
    }
}
