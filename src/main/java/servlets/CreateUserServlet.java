package servlets;

import service.ServiceImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateUserServlet extends HttpServlet {
    ServiceImpl service = ServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        Integer age = Integer.parseInt(req.getParameter("age"));
//        if( name.equals("")||surname.equals("")){
//            name=null;
//            surname=null;
//            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req,resp);
//        }
        if (name != null && surname != null && age != null) {
            service.addUser(new User(name, surname, age));
           // resp.sendRedirect("read");
        }
        resp.sendRedirect("read");
    }
}
