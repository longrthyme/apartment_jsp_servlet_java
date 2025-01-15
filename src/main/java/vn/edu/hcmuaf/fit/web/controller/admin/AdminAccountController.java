package vn.edu.hcmuaf.fit.web.controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.web.dao.AccountDAO;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;
import vn.edu.hcmuaf.fit.web.dao.model.User;

@WebServlet("/admin/account")
public class AdminAccountController extends HttpServlet {

    private AccountDAO accountDao = new AccountDAO();

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        switch (action != null ? action : "list") {
            case "list":
                listUser(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteAccount(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                insertUser(request, response);
                break;
            case "update":
                updateAccount(request, response);
                break;
            default:
                response.sendRedirect("admin/account?action=list");
                break;
        }
    }



     private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In list user method ");
        List<User> users = accountDao.getUsersByRoleID(0);

        System.out.println("Length user " + users.size());

        // User firstApartment = users.get(0);

     
        
        request.setAttribute("users", users);
        request.getRequestDispatcher("/Admin/account/list.jsp").forward(request, response);
    }


    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In shw form");
        request.getRequestDispatcher("/Admin/account/add.jsp").forward(request, response);
    }




    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int accountId = Integer.parseInt(request.getParameter("id"));
User user = accountDao.getAccountById(accountId);


if (user != null) {

    System.out.println("detail apart id " + accountId );

    request.setAttribute("apartment", user);
    request.getRequestDispatcher("/Admin/account/edit.jsp").forward(request, response);
} else {
    System.out.println("detail apart id " + accountId );
    // Handle the case where the apartment with the given ID doesn't exist
    request.setAttribute("error", "Apartment not found.");
    request.getRequestDispatcher("/path/to/errorPage.jsp").forward(request, response);
}


    }


    private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int roleID = Integer.parseInt(request.getParameter("roleID"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
    
        System.out.println("IN update specific " + id);
    
        // Create a User object with the updated data
        User user = new User(id, roleID, name, password, email, phone);
    
        // Call DAO method to update the user in the database
        accountDao.updateUser(user);
    
        // Redirect to the list page after successful update
        response.sendRedirect(request.getContextPath() + "/admin/account?action=list");
    }

    

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
    try {
        accountDao.deleteAccount(id);
        response.sendRedirect(request.getContextPath() + "/admin/account?action=list");
    } catch (RuntimeException e) {
        String errorMessage = e.getMessage().contains("foreign key") 
            ? "Failed to delete account. Foreign key restriction."
            : "Failed to delete account. Please try again.";

        request.getSession().setAttribute("errorMessage", errorMessage);
        response.sendRedirect(request.getContextPath() + "/admin/account?action=list");
    }
    }



    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("In insert user");
    
        // Retrieve user details from the request
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int roleID = Integer.parseInt("0");
    
        // Create a new User object
        User user = new User(0, roleID, name, password, email, phone); // ID will be auto-generated by the database
    
        // Call DAO to insert the user
        accountDao.insertUser(user);
    
        // Redirect to the user list page after successful insertion
        response.sendRedirect(request.getContextPath() + "/admin/account?action=list");
    }
    
}



