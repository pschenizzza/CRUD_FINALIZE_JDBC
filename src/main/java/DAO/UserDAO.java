package DAO;

import model.User;

import java.util.List;

public interface UserDAO {


    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(String username, String password);
    void editUser(String username, String gender, String password);

    User getUserByName(String username);
}
