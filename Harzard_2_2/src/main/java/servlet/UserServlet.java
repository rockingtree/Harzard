package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userList")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("userName");
        String password = req.getParameter("pwd");

        System.out.println("userName: " + username);
        System.out.println("password: " + password);

        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAll();
        for (User user : users) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                if (user.getType().equals("admin")) {
                    req.getRequestDispatcher("/admin/main.jsp").forward(req, resp);
                } else if (user.getType().equals("common")) {
                    req.getRequestDispatcher("/common/main.jsp").forward(req, resp);
                }
            }
        }
        req.getRequestDispatcher("/fail.jsp").forward(req, resp);
    }
}
