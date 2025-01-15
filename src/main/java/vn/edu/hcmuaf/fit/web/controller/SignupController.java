package vn.edu.hcmuaf.fit.web.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.web.dao.*;
import vn.edu.hcmuaf.fit.web.dao.model.Apartment;
import vn.edu.hcmuaf.fit.web.dao.model.ApartmentType;
import vn.edu.hcmuaf.fit.web.dao.model.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignupController", value = "/signup")
public class SignupController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng về trang đăng ký khi có yêu cầu GET
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // Kiểm tra mật khẩu có khớp hay không
        if (!password.equals(confirmPassword)) {
            request.setAttribute("mess", "Mật khẩu không trùng khớp!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng DAO
        SignupDao dao = new SignupDao();

        // Kiểm tra tài khoản đã tồn tại chưa
        User existingUser = dao.checkUser(username);
        if (existingUser != null) {
            request.setAttribute("mess1", "Tài khoản đã tồn tại!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Thực hiện đăng ký
        boolean isRegistered = dao.register(username, password, phone, email);
        if (isRegistered) {
            // Đăng ký thành công, chuyển hướng đến trang home
            ApartmentTypeSellDao dao1 = new ApartmentTypeSellDao();
            ApartmentTypeRentDao dao2 = new ApartmentTypeRentDao();

            List<ApartmentType> list1 = dao1.getDetailCategory();
            List<ApartmentType> list2 = dao2.getDetailCategory();

            request.setAttribute("listS", list1);
            request.setAttribute("listR", list2);


            ApartmentDao adao = new ApartmentDao();
            List<Apartment> listsell = adao.getAllProductsSell();
            List<Apartment> listrent = adao.getAllProductsRent();

            ApartmentNewDao newdao = new ApartmentNewDao();
            List<Apartment> listnew = newdao.getAllProductsNew();



            request.setAttribute("listP", listsell);
            request.setAttribute("listPP", listrent);
            request.setAttribute("listN", listnew);

            ApartmentAreaDao areaDao = new ApartmentAreaDao();
            List<Apartment> listArea = areaDao.getApartmentByArea("TP.Hồ Chí Minh");
            request.setAttribute("listHCM", listArea);

            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            // Đăng ký thất bại, hiển thị lỗi
            request.setAttribute("mess", "Đăng ký thất bại. Vui lòng thử lại sau!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }
}
