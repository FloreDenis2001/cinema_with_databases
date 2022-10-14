package model;

import lombok.Data;

@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int programari_id;
    private int user_id;
    private double amount;

    public Ticket(int id, int programari_id, int user_id, double amount) {
        this.id = id;
        this.programari_id = programari_id;
        this.user_id = user_id;
        this.amount = amount;
    }
    public Ticket(int programari_id, int user_id, double amount) {
        this.programari_id = programari_id;
        this.user_id = user_id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        String text = "Programare Id : " + this.programari_id + "\n";
        text += "User Id : " + this.user_id + "\n";
        text += "Amount : " + this.amount + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Ticket x = (Ticket) o;
        return this.amount == x.getAmount();
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.amount > o.getAmount()) {
            return 1;
        } else if (this.amount < o.getAmount()) {
            return -1;
        } else {
            return 0;
        }
    }
}
