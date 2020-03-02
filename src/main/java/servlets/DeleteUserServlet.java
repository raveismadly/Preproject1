package servlets;

import service.ServiceImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    ServiceImpl service = ServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long reqId = Long.parseLong(req.getParameter("id"));
        User user = null;
        try {
            user = service.getUserById(reqId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        try {
            service.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("read");
    }
}
