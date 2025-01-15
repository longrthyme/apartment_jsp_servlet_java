package vn.edu.hcmuaf.fit.web.controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.web.dao.ApartmentAreaDao;
import vn.edu.hcmuaf.fit.web.dao.ApartmentDao;
import vn.edu.hcmuaf.fit.web.dao.ApartmentNewDao;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;


@WebServlet("/admin/apartment")
public class AdminApartmentController extends HttpServlet {
    private ApartmentDao apartmentDao = new ApartmentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action != null ? action : "list") {
            case "list":
                listApartments(request, response);
                break;
            case "add":
                // showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                // deleteApartment(request, response);
                break;
            default:
                listApartments(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                // insertApartment(request, response);
                break;
            case "update":
                updateApartment(request, response);
                break;
            default:
                response.sendRedirect("admin/apartment?action=list");
                break;
        }
    }

    private void listApartments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Apartment> apartments = apartmentDao.getAllApartments();

        Apartment firstApartment = apartments.get(0);

        // Print each field of the first apartment
        System.out.println("ID: " + firstApartment.getId());
        System.out.println("Name: " + firstApartment.getName());
        System.out.println("Description: " + firstApartment.getDescribe());
        System.out.println("Price: " + firstApartment.getPrice());
        System.out.println("Area: " + firstApartment.getArea());
        System.out.println("Bedroom: " + firstApartment.getBedroom());
        System.out.println("Bathroom: " + firstApartment.getBathroom());
        System.out.println("Toilet: " + firstApartment.getToilet());
        System.out.println("Interior: " + firstApartment.getInterior());
        System.out.println("Legal: " + firstApartment.getLegal());
        System.out.println("Posted Date: " + firstApartment.getPostedDate()); // Use formatted date if necessary
        System.out.println("URL: " + firstApartment.getUrl());
        System.out.println("View Count: " + firstApartment.getViewCount());
        System.out.println("Address: " + firstApartment.getNameAddress());


        System.out.println("length apartment " + apartments.size());
        request.setAttribute("apartments", apartments);
        request.getRequestDispatcher("/Admin/apartment/list.jsp").forward(request, response);
    }

    // private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     request.getRequestDispatcher("/admin/apartment/add.jsp").forward(request, response);
    // }

    // private void insertApartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //     String name = request.getParameter("name");
    //     String describe = request.getParameter("describe");
    //     double price = Double.parseDouble(request.getParameter("price"));
    //     double area = Double.parseDouble(request.getParameter("area"));
    //     int bedroom = Integer.parseInt(request.getParameter("bedroom"));
    //     int bathroom = Integer.parseInt(request.getParameter("bathroom"));
    //     int toilet = Integer.parseInt(request.getParameter("toilet"));
    //     String interior = request.getParameter("interior");
    //     String legal = request.getParameter("legal");

    //     Apartment apartment = new Apartment(0, name, describe, price, area, bedroom, bathroom, toilet, interior, legal, LocalDateTime.now(), null, 0, null);
    //     apartmentDao.insertApartment(apartment);
    //     response.sendRedirect("admin/apartment?action=list");
    // }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int apartmentId = Integer.parseInt(request.getParameter("id"));
Apartment apartment = apartmentDao.getApartmentById(apartmentId);


if (apartment != null) {

    System.out.println("detail apart id " + apartmentId + " " + apartment.getId());

    request.setAttribute("apartment", apartment);
    request.getRequestDispatcher("/Admin/apartment/edit.jsp").forward(request, response);
} else {
    System.out.println("detail apart id " + apartmentId );
    // Handle the case where the apartment with the given ID doesn't exist
    request.setAttribute("error", "Apartment not found.");
    request.getRequestDispatcher("/path/to/errorPage.jsp").forward(request, response);
}

        // int id = Integer.parseInt(request.getParameter("id"));
        // Apartment existingApartment = apartmentDao.getApartmentById(id);
        // request.setAttribute("apartment", existingApartment);
        // request.getRequestDispatcher("/admin/apartment/edit.jsp").forward(request, response);
    }

    private void updateApartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        System.out.println("IN update specific " + id);
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        double price = Double.parseDouble(request.getParameter("price"));
        double area = Double.parseDouble(request.getParameter("area"));
        int bedroom = Integer.parseInt(request.getParameter("bedroom"));
        int bathroom = Integer.parseInt(request.getParameter("bathroom"));
        int toilet = Integer.parseInt(request.getParameter("toilet"));
        String interior = request.getParameter("interior");
        String legal = request.getParameter("legal");
        String address = request.getParameter("nameAddress");

        

        Apartment apartment = new Apartment(id, name, describe, price, area, bedroom, bathroom, toilet, interior, legal, LocalDateTime.now(), null, 0, address);

        System.out.println("id after update " + apartment.getId());
        apartmentDao.updateApartment(apartment);
        response.sendRedirect(request.getContextPath() + "/admin/apartment?action=list");
    }

    // private void deleteApartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //     int id = Integer.parseInt(request.getParameter("id"));
    //     apartmentDao.deleteApartment(id);
    //     response.sendRedirect("admin/apartment?action=list");
    // }
}