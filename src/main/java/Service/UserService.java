package Service;

import User.User;
import UserDAO.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public List<User> getAllUsers() throws SQLException {
        return new UserDAO().getAllUsers();
    }

    public void addUser(User user) {
        new UserDAO().addUser(user);
    }

    public boolean updateUser(User user) throws SQLException {
        return new UserDAO().updateUser(user);
    }

    public boolean deleteUser(Long id) throws SQLException {
        return new UserDAO().deleteUser(id);
    }
    public User getUserById(Long id) throws SQLException {
        return new UserDAO().getUserById(id);
    }
}
