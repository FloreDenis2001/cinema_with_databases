package model;

import lombok.Data;

@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int schedules_id;
    private int user_id;
    private double amount;
    private int seat_id;

    public Ticket(int id, int schedules_id, int user_id, double amount, int seat_id) {
        this.id = id;
        this.schedules_id = schedules_id;
        this.user_id = user_id;
        this.amount = amount;
        this.seat_id = seat_id;
    }

    @Override
    public String toString() {
        String text = "Schedules Id : " + this.schedules_id + "\n";
        text += "User Id : " + this.user_id + "\n";
        text += "Amount : " + this.amount + "\n";
        text += "Seat Id : " + this.seat_id + "\n";
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
