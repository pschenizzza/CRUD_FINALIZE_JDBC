package DAO;

import database.DatabaseConnection;

public class DaoConnection {
    public static UserDAO getDaoConnection() {
        return new UserDAOImpl(DatabaseConnection.getConnection());
    }
}
