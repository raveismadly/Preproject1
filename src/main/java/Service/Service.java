package Service;

import User.User;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    void addUser(User user);

    boolean deleteUser(Long id) throws SQLException;

    List<User> getAllUser();

    User getUserById(Long id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}
