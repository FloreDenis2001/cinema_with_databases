package model;

import exceptii.StatusException;

import java.time.LocalDateTime;

public class Programare {
    private int id;
    private int room_id;
    private int movie_id;
    private int seats_id;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public Programare(int id,int room_id,int movie_id,int seats_id, LocalDateTime startTime, LocalDateTime finishTime) {
        this.id = id;
        this.room_id = room_id;
        this.movie_id = movie_id;
        this.seats_id = seats_id;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public Programare(int room_id, int movie_id, int seats_id, LocalDateTime startTime, LocalDateTime finishTime) {
        this.room_id = room_id;
        this.movie_id = movie_id;
        this.seats_id = seats_id;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getSeats_id() {
        return seats_id;
    }

    public void setSeats_id(int seats_id) {
        this.seats_id = seats_id;
    }

    public Programare(String startTime, String finishTime) throws StatusException {
        int yy = Integer.parseInt(startTime.split(",")[0]);
        int mm = Integer.parseInt(startTime.split(",")[1]);
        int dd = Integer.parseInt(startTime.split(",")[2]);
        int hh = Integer.parseInt(startTime.split(",")[3]);
        int min = Integer.parseInt(startTime.split(",")[4]);



        int yys = Integer.parseInt(finishTime.split(",")[0]);
        int mms = Integer.parseInt(finishTime.split(",")[1]);
        int dds = Integer.parseInt(finishTime.split(",")[2]);
        int hhs = Integer.parseInt(finishTime.split(",")[3]);
        int mins = Integer.parseInt(finishTime.split(",")[4]);

        if (LocalDateTime.of(yy, mm, dd, hh, min).compareTo(LocalDateTime.of(yys, mms, dds, hhs, mins)) < 0) {
            this.startTime = LocalDateTime.of(yy, mm, dd, hh, min);
            this.finishTime = LocalDateTime.of(yys, mms, dds, hhs, mins);
        } else {
            throw new StatusException("Datele nu sunt introduse corect ! ");
        }
    }


    @Override
    public String toString(){
        String text =  "Movie Id : "+this.movie_id+"\n";
        text+="Room Id: "+this.room_id+"\n";
        text+="Seat Id : "+this.seats_id+"\n";
        text+="Start Time : "+this.startTime+"\n";
        text+="Finish Time :"+this.finishTime+"\n";
return text;
    }
}
