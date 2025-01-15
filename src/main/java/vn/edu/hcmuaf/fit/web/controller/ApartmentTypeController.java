package vn.edu.hcmuaf.fit.web.controller; import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.web.dao.ApartmentTypeRentDao;
import vn.edu.hcmuaf.fit.web.dao.ApartmentTypeSellDao;
import vn.edu.hcmuaf.fit.web.dao.model.ApartmentType;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApartmentTypeController", value = "/ApartmentTypeController")
public class ApartmentTypeController extends HttpServlet {

@Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ApartmentTypeSellDao dao1 = new ApartmentTypeSellDao();
    ApartmentTypeRentDao dao2 = new ApartmentTypeRentDao();

    List<ApartmentType> list1 = dao1.getDetailCategory();
    List<ApartmentType> list2 = dao2.getDetailCategory();

    request.setAttribute("listS", list1);
    request.setAttribute("listR", list2);
    request.getRequestDispatcher("home.jsp").forward(request, response);
}

@Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
}
