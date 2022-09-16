package model;

import lombok.Data;

@Data
public abstract class User implements Comparable<User> {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private String roles;

    public User(int id, String firstName, String lastName, int age, String email, String password, String roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String firstName, String lastName, int age, String email, String password, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


    @Override
    public String toString() {
        String text = "First Name : " + this.firstName + "\n";
        text += "Last Name : " + this.lastName + "\n";
        text += "Email : " + this.email + "\n";
        text += "Age : " + this.age + "\n";
        text += "Roles : " + this.roles + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        User x = (User) o;
        return x.getEmail().compareTo(this.email) == 0;
    }

    @Override
    public int compareTo(User o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
