package UserDAO;

import User.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
     void addUser(User user);
     User getUserById(Long id)throws SQLException;
    boolean updateUser(User user) throws SQLException;
    boolean deleteUser(Long id) throws SQLException;
    List<User> getAllUser();
}
