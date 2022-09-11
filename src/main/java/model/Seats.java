package model;

import lombok.Data;

@Data
public class Seats implements Comparable<Seats> {
    private int id;
    private int room_id;
    private int seatNumber;

    public Seats(int id, int room_id, int seatNumber) {
        this.id = id;
        this.room_id = room_id;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        String text = "Room Id : " + this.room_id + "\n";
        text += "Seat Number : " + this.seatNumber + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Seats x = (Seats) o;
        return this.seatNumber == x.getSeatNumber();
    }


    @Override
    public int compareTo(Seats o) {
        if (this.seatNumber > o.getSeatNumber()) {
            return 1;
        } else if (this.seatNumber < o.getSeatNumber()) {
            return -1;
        } else {
            return 0;
        }
    }
}
