package vn.edu.hcmuaf.fit.web.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.web.dao.ApartmentAreaDao;
import vn.edu.hcmuaf.fit.web.dao.ApartmentDao;
import vn.edu.hcmuaf.fit.web.dao.ApartmentNewDao;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeController", value = "/home")
public class ApartmentController extends HttpServlet {

    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //     ApartmentDao dao = new ApartmentDao();
    //     List<Apartment> listSell = dao.getAllProductsSell();
    //     List<Apartment> listRent = dao.getAllProductsRent();
    //     request.setAttribute("listP", listSell);
    //     request.setAttribute("listPP", listRent);

    //     ApartmentNewDao newdao = new ApartmentNewDao();
    //     List<Apartment> listnew = newdao.getAllProductsNew();
    //     request.setAttribute("listN", listnew);

    //     ApartmentAreaDao areaDao = new ApartmentAreaDao();
    //     List<Apartment> listArea = areaDao.getApartmentByArea("TP.Hồ Chí Minh");
    //     request.setAttribute("listHCM", listArea);


    //     request.getRequestDispatcher("home.jsp").forward(request, response);

    // }

    private ApartmentDao apartmentDao;

    @Override
    public void init() throws ServletException {
        apartmentDao = new ApartmentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                listApartments(request, response);
                break;
            case "add":
                // showAddForm(request, response);
                break;
            case "edit":
                // showEditForm(request, response);
                break;
            case "delete":
                // deleteApartment(request, response);
                break;
            default:
                listApartments(request, response);
                break;
        }
    }

    private void listApartments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Apartment> apartments = apartmentDao.getAllProductsRent();
        request.setAttribute("apartments", apartments);
        request.getRequestDispatcher("/Admin/apartment/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
