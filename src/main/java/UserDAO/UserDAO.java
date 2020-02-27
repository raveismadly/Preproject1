package UserDAO;

import User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String GET_USER_BY_ID = "SELECT id, name, surname, age FROM users where id = ?";
    private static final String UPDATE_USER = "UPDATE users SET name = ?, surname = ?, age = ? WHERE id= ?";
    private static final String GET_ALL_USERS = "SELECT * FROM users";
    private static final String ADD_USER = "INSERT INTO users (name, surname, age) VALUE (?, ?, ?)";
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idUser = resultSet.getLong(1);
                String nameUser = resultSet.getString(2);
                String surnameUser = resultSet.getString(3);
                int ageUser = resultSet.getInt(4);
                list.add(new User(idUser, nameUser, surnameUser, ageUser));
            }
        } catch (SQLException e) {
            System.out.println("from getAllUsers: " + e.getErrorCode());
        }
        return list;
    }

    public void addUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUser(User user) throws SQLException {
        boolean updated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
           // preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setLong(4, user.getId());

            // preparedStatement.executeUpdate();
            updated = preparedStatement.executeUpdate() > 0;
        }
        return updated;

    }

    public boolean deleteUser(Long id) throws SQLException {
        boolean deleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM users  WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            deleted = preparedStatement.executeUpdate() > 0;
        }
        return deleted;
    }

    public User getUserById(Long id) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                user = new User(id,name, surname, age);
            }
            return user;
        }

    }

}
