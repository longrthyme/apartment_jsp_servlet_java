package vn.edu.hcmuaf.fit.web.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.web.dao.AccountDAO;
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
                // showAddForm(request, response);
                break;
            case "edit":
                // showEditForm(request, response);
                break;
            case "delete":
                // deleteApartment(request, response);
                break;
            default:
                // listApartments(request, response);
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







}

