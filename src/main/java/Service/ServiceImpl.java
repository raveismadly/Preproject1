package Service;

import User.User;
import UserDAO.UserDAOImpl;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements Service {
    protected DBHelper dbHelper;

    private UserDAOImpl dao = new UserDAO.UserDAOImpl(dbHelper.getConnection());

    public void addUser(User user) {
        dao.addUser(user);
    }

    public boolean deleteUser(Long id) throws SQLException {
        return dao.deleteUser(id);
    }

    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    public User getUserById(Long id) throws SQLException {
        return dao.getUserById(id);
    }

    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }
}
