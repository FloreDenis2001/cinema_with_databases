package repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Repository {
    private String JdbcURL = "jdbc:mysql://localhost:3306/";
    private String username = "root";
    private String password = "Decembrie2001";
    private Connection connection = null;
    public Statement statement = null;


    public Repository(String database) {
        try {

            JdbcURL+=database;;
            connection = DriverManager.getConnection(JdbcURL, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Erroare conectare Baza de Date ! " + e.getMessage());
        }
    }

    public void executeStatement(String execute) {
        try {
            statement.execute(execute);
        } catch (SQLException exc) {
            System.out.println("Nu am reusit " + execute);
        }
    }

    public abstract void insert(Object o);

}
