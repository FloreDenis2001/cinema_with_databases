package model;


public class Client extends User {
    private int yearsOld;

    public Client(int id, String firstName, String lastName, int age, String email, String password, int degreeOfLoyalty) {
        super(id, firstName, lastName, age, email, password, "client");
        this.yearsOld = degreeOfLoyalty;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    @Override
    public String toString() {
        String text = super.toString() + "\n";
        text += "Years Old : " + this.yearsOld + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o){
        Client x = (Client) o;
        return this.yearsOld==x.getYearsOld();
    }


}
