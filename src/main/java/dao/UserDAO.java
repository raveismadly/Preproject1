package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> getAllUser() throws SQLException;

    void addUser(User user);

    boolean updateUser(User user) throws SQLException;

    boolean deleteUser(Long id) throws SQLException;

    User getUserById(Long id) throws SQLException;

}


