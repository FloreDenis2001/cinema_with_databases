package repository;

import model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepo extends Repository {

    public UserRepo(String database) {
        super(database);
    }

    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate users";
        executeStatement(eraseAll);

    }
    @Override
    public void insert(Object o) {
        User c = (User) o;
        String insert = "insert into users (firstName, lastName, age, email, password, roles) value(" + String.format("'%s','%s',%d,'%s','%s','%s'", c.getFirstName(), c.getLastName(), c.getAge(), c.getEmail(), c.getPassword(), c.getRoles()) + ")";
        executeStatement(insert);
    }

    public void delete(String email, String password) {
        String del = String.format("delete from users where email='%s' && password ='%s'", email, password);
        executeStatement(del);
    }

    public void update(String email , String password ,String new_password){
        String update = String.format("update users set password='%s' where email='%s' && password ='%s'",new_password,email,password);
        executeStatement(update);
    }

    public List<User> allUsers() {
        executeStatement("select * from users");
        List<User> users = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                users.add(new User(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4), set.getString(5), set.getString(6), set.getString(7)));
            }
            return users;
        } catch (Exception e) {
            System.out.println("ERROR schita nu exista !");
            return null;
        }
    }

    public User findUser(String email) {
        List<User> users = allUsers();
        for (User x : users)
            if (x.getEmail().compareTo(email) == 0)
                return x;
        return null;
    }
}
