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

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
  //  private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long reqId = Long.parseLong(req.getParameter("id"));
        User haveThisUser = null;
        try {
            haveThisUser = new UserService().getUserById(reqId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("haveThisUser", haveThisUser);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String reqUpdateName = req.getParameter("name");
        String reqUpdateSurname = req.getParameter("surname");
        Integer reqUpdateAge = Integer.parseInt(req.getParameter("age"));
        if (reqUpdateAge != null && reqUpdateSurname != null && reqUpdateAge != null) {
            try {
                new UserService().updateUser(new User(id, reqUpdateName, reqUpdateSurname, reqUpdateAge));
                resp.sendRedirect("read");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
