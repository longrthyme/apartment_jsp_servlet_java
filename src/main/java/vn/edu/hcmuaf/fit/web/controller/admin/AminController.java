package vn.edu.hcmuaf.fit.web.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.web.dao.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AminController", value = "/admin/welcome")
public class AminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("WELCOME ADMIN");
        out.println(request.getRequestURI());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}