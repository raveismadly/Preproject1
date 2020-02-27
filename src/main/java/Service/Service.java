package Service;

import User.User;
import UserDAO.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class Service {
    public void addUser(User user){
         new UserDAO().addUser(user);
    }
    public boolean deleteUser(Long id) throws SQLException {
        return new UserDAO().deleteUser(id);
    }
    public List<User> getAllUser(){
        return new UserDAO().getAllUser();
    }
    public User getUserById(Long id) throws SQLException {
        return new UserDAO().getUserById(id);
    }
    public  boolean updateUser(User user){
        return new UserDAO().updateUser(user);
    }
}
