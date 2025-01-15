package vn.edu.hcmuaf.fit.web.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.web.dao.DetailsDao;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailsController", value = "/details")
public class DetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        DetailsDao dao = new DetailsDao();
        List<Apartment> listDetails = dao.getDetailsApartment(aid);
        request.setAttribute("listPPP", listDetails);
        request.getRequestDispatcher("product-details.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
