package service;

import model.User;
import dao.UserDAO;
import dao.UserDAOImpl;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements Service {
   // protected DBHelper dbHelper;
    private static ServiceImpl serviceImpl;
    private static  UserDAO userDAO;

    //private UserDAOImpl dao = new UserDAOImpl(dbHelper.getConnection());

    public ServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public static ServiceImpl getInstance() {
        if (serviceImpl == null) {
            serviceImpl = new ServiceImpl(new UserDAOImpl(DBHelper.getConnection()));
        }
        return serviceImpl;
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public boolean deleteUser(Long id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    public User getUserById(Long id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }
}
