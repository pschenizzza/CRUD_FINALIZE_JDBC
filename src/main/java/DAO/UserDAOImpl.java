package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM user_account");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String gender = resultSet.getString("gender");
                String password = resultSet.getString("password");
                allUsers.add(new User(id, username, gender, password));
            }
        } catch (SQLException e) {
            System.out.println("Exception from getAllUsers");
            e.printStackTrace();
        }
        return allUsers;
    }


    @Override
    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_account(username, gender, password) VALUES (?,?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getPassword());
            if (preparedStatement.executeUpdate() != 0) {
                preparedStatement.close();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Exception from addUser");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user_account WHERE username=? AND password=? ");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("User " + username + " doesnt exist");
            e.printStackTrace();
        }
    }


    @Override
    public void editUser(String username, String gender, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user_account SET username=?, password=?, gender=? WHERE id=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(2, gender);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Exception from deleteUser");
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByName(String username) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM user_account WHERE username=?");
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                user = new User(username, password, gender);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Exception from getUserByName");
            e.printStackTrace();
        }
        return user;


    }

}
