package UserDAO;

import User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    private String mySql = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
    private String admin = "admin";
    private String pass = "admin";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(mySql, admin, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addUser(User user) {
        try (Connection connection = getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement("INSERT INTO users (name, surname, age) VALUE(?,?,?) ")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(Long id)throws SQLException {
        User user = null;
        try (Connection connection = getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement("select id, name, surname, age from users where id=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                user = new User(id, name, surname, age);
            }
        }
        return user;
    }

    public boolean updateUser(User user) {
        boolean updated = false;
        try (Connection connection = getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement("update users set name=?,surname=?,age=? where id=?")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setLong(4, user.getId());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement("select * from users")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                list.add(new User(id, name, surname, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
