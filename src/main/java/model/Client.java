package model;


public class Client extends User {

    public Client(int id, String firstName, String lastName, int age, String email, String password) {
        super(id, firstName, lastName, age, email, password, "client");
    }
     public Client(String firstName, String lastName, int age, String email, String password) {
        super(firstName, lastName, age, email, password, "client");
    }

}
