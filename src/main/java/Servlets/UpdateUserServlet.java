package Servlets;

import Service.Service;
import User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        User haveThisUser = null;
        try {
            haveThisUser = new Service().getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("haveThisUser", haveThisUser);
        req.getRequestDispatcher("WEB-INF/jsp/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String updatedName = req.getParameter("name");
        String updatedSurname = req.getParameter("surname");
        Integer updatedAge = Integer.parseInt(req.getParameter("age"));
        if (updatedName != null && updatedSurname != null && updatedAge != null) {
            new Service().updateUser(new User(id, updatedName, updatedSurname, updatedAge));
            resp.sendRedirect("read");
        }

    }
}
