package repository;

import model.Movie;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieRepo extends Repository {
    public MovieRepo(String database) {
        super(database);
    }

    @Override
    public void insert(Object o) {
        Movie x = (Movie) o;
        String insert = "insert into  movie (title, type, duration) values(" + String.format("'%s','%s',%d", x.getTitle(), x.getType(), x.getDuration()) + ")";
        executeStatement(insert);
    }


    public void delete(String title) {
        String delete = String.format("delete from movie where title='%s'", title);
        executeStatement(delete);
    }

    public void update(String title, int duration) {
        String update = String.format("update movie set duration=%d where title='%s'", duration, title);
        executeStatement(update);
    }

    public List<Movie> allMovie() {
        executeStatement("select * from movie");
        List<Movie> movies = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                movies.add(new Movie(set.getString(2), set.getString(3), set.getInt(4)));
            }
            return movies;
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita ! ");
            return null;
        }
    }

    public Movie findMovie(String title) {
        List<Movie> movies = allMovie();
        for (Movie x : movies)
            if (x.getTitle().compareTo(title) == 0)
                return x;


        return null;
    }

    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate movie";
        executeStatement(eraseAll);
    }
}


