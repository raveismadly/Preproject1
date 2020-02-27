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

@WebServlet("/create")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqName = req.getParameter("name");
        String reqSurname = req.getParameter("surname");
        Integer reqAge = Integer.parseInt(req.getParameter("age"));
        if (reqName != null && reqSurname != null && reqAge != null) {
            new UserService().addUser(new User(reqName, reqSurname, reqAge));
            resp.sendRedirect("read");
        }
    }
}
