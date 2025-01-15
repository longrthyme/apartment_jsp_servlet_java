package vn.edu.hcmuaf.fit.web.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.web.dao.SearchDao;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchCriteriaController", value = "/SearchCriteriaController")
public class SearchCriteriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
        String city = request.getParameter("city");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String area = request.getParameter("area");
        String bedroom = request.getParameter("bedroom");

        // Gọi DAO để tìm kiếm
        SearchDao dao = new SearchDao();
        List<Apartment> apartments = dao.searchApartments(txtSearch, city, type, price, area, bedroom);

        // Gửi kết quả về trang JSP

        if (apartments != null) {
            request.setAttribute("res", "Kết quả tìm kiếm");
            request.setAttribute("listS", apartments);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else{
            request.setAttribute("res", txtSearch + "không tồn tại ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
