package servlets;


import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/adduser")
public class AddServlet extends HttpServlet {

    UserService userService = UserService.getInstance();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

        userService.addUser(new User(username, password, gender));
        req.setAttribute("username", username);
        req.setAttribute("message", "User added");
        resp.sendRedirect("userlist");
    }

}
