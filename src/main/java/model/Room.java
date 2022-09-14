package model;

import lombok.Data;

@Data
public class Room implements Comparable<Room> {
    private int id;
    private String name;
    private String type;
    private int max_seats;

    public Room(int id, String name, String type, int max_seats) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.max_seats = max_seats;
    }

    public Room(String name, String type, int max_seats) {
        this.name = name;
        this.type = type;
        this.max_seats = max_seats;
    }


    @Override
    public String toString() {
        String text = "Type : " + this.type + "\n";
        text += "Max Seats " + this.max_seats + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Room x = (Room) o;
        return this.getMax_seats() == x.getMax_seats();
    }

    @Override
    public int compareTo(Room o) {
        if (this.max_seats > o.getMax_seats()) {
            return 1;
        } else if (this.max_seats < o.getMax_seats()) {
            return -1;
        } else {
            return 0;
        }
    }
}
