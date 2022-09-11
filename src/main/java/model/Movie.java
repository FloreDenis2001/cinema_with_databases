package model;

import lombok.Data;

@Data
public class Movie implements Comparable<Movie> {
    private int id;
    private String title;
    private String type;
    private int duration;

    public Movie(int id, String title, String type, int duration) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.duration = duration;
    }
    public Movie(String title, String type, int duration) {
        this.title = title;
        this.type = type;
        this.duration = duration;
    }


    @Override
    public String toString() {
        String text = "Title : " + this.title + "\n";
        text += "Type : " + this.type + "\n";
        text += "Duration : " + this.duration + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Movie x = (Movie) o;
        return this.getTitle().compareTo(x.getTitle()) == 0;
    }

    @Override
    public int compareTo(Movie o) {
        if (this.duration > o.getDuration()) {
            return 1;
        } else if (this.duration < o.getDuration()) {
            return -1;
        } else {
            return 0;
        }
    }
}
