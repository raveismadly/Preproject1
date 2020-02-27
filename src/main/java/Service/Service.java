package Service;

import model.User;
import dao.UserDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class Service {
    public void addUser(User user){
         new UserDAOImpl().addUser(user);
    }
    public boolean deleteUser(Long id) throws SQLException {
        return new UserDAOImpl().deleteUser(id);
    }
    public List<User> getAllUser(){
        return new UserDAOImpl().getAllUser();
    }
    public User getUserById(Long id) throws SQLException {
        return new UserDAOImpl().getUserById(id);
    }
    public  boolean updateUser(User user){
        return new UserDAOImpl().updateUser(user);
    }
}
