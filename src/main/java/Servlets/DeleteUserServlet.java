package Servlets;

import Service.UserService;
import User.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long reqId = Long.parseLong(req.getParameter("id"));
        User user = null;
        try {
            user = new UserService().getUserById(reqId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("user", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long reqId = Long.parseLong(req.getParameter("id"));
        try {
            new UserService().deleteUser(reqId);
            resp.sendRedirect("read");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
