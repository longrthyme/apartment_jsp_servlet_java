//package vn.edu.hcmuaf.fit.web.services;
//
//import vn.edu.hcmuaf.fit.web.dao.UserDao;
//import vn.edu.hcmuaf.fit.web.dao.model.User;
//
//public class UserService {
//    UserDao userDao;
//    public User checkLogin(String username, String password) {
//        UserDao userDao = new UserDao();
//        User login = userDao.getUser(username);
//        if (login == null) return false;
//        if (login.getPassword().equals(password)) return true;
//        return login.getPassword().equals(password);
//
//    }
//}
