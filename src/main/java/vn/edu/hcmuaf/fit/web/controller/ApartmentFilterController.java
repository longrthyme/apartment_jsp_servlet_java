package vn.edu.hcmuaf.fit.web.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.web.dao.ApartmentFilterDao;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/category")
public class ApartmentFilterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String sid = request.getParameter("sid");
    String rid = request.getParameter("rid");

    ApartmentFilterDao daosell = new ApartmentFilterDao();
    ApartmentFilterDao daorent = new ApartmentFilterDao();

    List<Apartment> listsell = daosell.getAllProductsFilterSell(sid);
    List<Apartment> listrent = daorent.getAllProductsFilterRent(rid);

    request.setAttribute("listP", listsell);
    request.setAttribute("listPP", listrent);
    request.getRequestDispatcher("home.jsp").forward(request, response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
