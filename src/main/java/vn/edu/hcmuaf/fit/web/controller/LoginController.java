//package vn.edu.hcmuaf.fit.web.controller;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import vn.edu.hcmuaf.fit.web.dao.ApartmentDao;
//import vn.edu.hcmuaf.fit.web.dao.ApartmentNewDao;
//import vn.edu.hcmuaf.fit.web.dao.LoginDao;
//import vn.edu.hcmuaf.fit.web.dao.model.Apartment;
//import vn.edu.hcmuaf.fit.web.dao.model.User;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "login", value = "/login")
//public class LoginController extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("user");
//        String password = request.getParameter("pass");
//        LoginDao dao = new LoginDao();
//        User user = dao.login(username, password);
//
//        if(user != null){
//            if(user.getRoleID()==1) {
//                request.getRequestDispatcher("admin.jsp").forward(request, response);
//            }else {
//                ApartmentDao adao = new ApartmentDao();
//                List<Apartment> listsell = adao.getAllProductsSell();
//                List<Apartment> listrent = adao.getAllProductsRent();
//
//                ApartmentNewDao newdao = new ApartmentNewDao();
//                List<Apartment> listnew = newdao.getAllProductsNew();
//
//
//
//                request.setAttribute("listP", listsell);
//                request.setAttribute("listPP", listrent);
//                request.setAttribute("listN", listnew);
//                request.getRequestDispatcher("home.jsp").forward(request, response);
//
//
//
//
//                request.getRequestDispatcher("home.jsp").forward(request, response);
//            }
//        }else {
//            request.setAttribute("mess", "Vui lòng nhập lại username và password!");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }
//
//
//    }
//}
