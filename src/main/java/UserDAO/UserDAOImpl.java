package UserDAO;

import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO {
    //    private String mySql = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
//    private String admin = "admin";
//    private String pass = "admin";
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(mySql, admin, pass);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
    // private DBHelper dbHelper;
    //private Connection connection;
//    public UserDAOImpl(Connection connection){
//        this.connection=connection;
//    }
    private Connection connection;//= DBHelper.getConnection();

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUser(User user) {
        try (PreparedStatement
                     preparedStatement = connection.prepareStatement("INSERT INTO users (name, surname, age) VALUE(?,?,?) ")) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {

            }
        }
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        User user = null;
        try (PreparedStatement
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

    @Override
    public boolean updateUser(User user) {
        boolean updated = false;
        try (PreparedStatement
                     preparedStatement = connection.prepareStatement("update users set name=?,surname=?,age=? where id=?;")) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setLong(4, user.getId());
            updated = preparedStatement.executeUpdate() > 0;
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
        return updated;
    }

    @Override
    public boolean deleteUser(Long id) throws SQLException {
        boolean deleted = false;
        try (
                PreparedStatement preparedStatement =
                        connection.prepareStatement(" delete from users where id = ?;")) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, id);
            if (preparedStatement.executeUpdate() > 0) {
                deleted = preparedStatement.executeUpdate() > 0;
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.setAutoCommit(true);
        }
        return deleted;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        try (PreparedStatement
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
