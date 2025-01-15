package vn.edu.hcmuaf.fit.web.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import vn.edu.hcmuaf.fit.web.dao.SearcnApartmentDao;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;
import vn.edu.hcmuaf.fit.web.dao.model.ApartmentType;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchApartmentController", value = "/search")
public class SearchApartmentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
        SearcnApartmentDao dao = new SearcnApartmentDao();
        List<Apartment> listSearch = dao.searchByName(txtSearch);
        if (listSearch != null) {
            request.setAttribute("res", "Kết quả tìm kiếm");
            request.setAttribute("listS", listSearch);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            request.setAttribute("txts",txtSearch);
        }else{
            request.setAttribute("res", txtSearch + "không tồn tại ");
        }





    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
