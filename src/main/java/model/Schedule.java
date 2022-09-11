package model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Schedule implements Comparable<Schedule> {
    private int id;
    private int room_id;
    private int movie_id;
    private LocalDateTime startTime;

    public Schedule(int id, int room_id, int movie_id, LocalDateTime startTime) {
        this.id = id;
        this.room_id = room_id;
        this.movie_id = movie_id;
        this.startTime = startTime;
    }


    @Override
    public String toString() {
        String text = "Room : " + this.room_id + "\n";
        text += "Movie : " + this.movie_id + "\n";
        text += "Start Time : " + this.startTime + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Schedule x = (Schedule) o;
        return x.getMovie_id() == this.movie_id;
    }

    @Override
    public int compareTo(Schedule o) {
        if (this.startTime.compareTo(o.getStartTime()) > 0) {
            return 1;
        } else if (this.startTime.compareTo(o.getStartTime()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
