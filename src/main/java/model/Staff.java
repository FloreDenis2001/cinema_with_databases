package model;


public class Staff extends User {

    private String type;

    public Staff(int id, String firstName, String lastName, int age, String email, String password, String type) {
        super(id, firstName, lastName, age, email, password, "staff");
        this.type = type;
    }

    public Staff(String firstName, String lastName, int age, String email, String password, String type) {
        super(firstName, lastName, age, email, password,"staff");
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String text = super.toString() + "\n";
        text += "Type : " + this.type + "\n";
        return text;
    }
}
