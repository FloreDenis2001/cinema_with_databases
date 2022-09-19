package services;

import exceptii.StatusException;
import model.Movie;
import repository.MovieRepo;

import java.time.LocalDateTime;
import java.util.List;

public class MovieService {
    MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo2) {
        movieRepo = movieRepo2;
    }


    public void printAllMovie() {
        List<Movie> movieList = movieRepo.allMovie();
        for (Movie x : movieList) {
            System.out.println(x);
        }
    }



    public Movie findByName(String movieName) {
        List<Movie> movieList = movieRepo.allMovie();
        for (Movie x : movieList)
            if (x.getTitle().compareTo(movieName) == 0)
                return x;
        return null;
    }

    public void addMovie(Movie x) throws StatusException {
        Movie t = findByName(x.getTitle());
        if (t == null) {
            movieRepo.insert(x);
        } else {
            throw new StatusException("Filmul exista !");
        }
    }

    public void deleteMovie(String titleOfMovie) throws StatusException {
        Movie t = findByName(titleOfMovie);
        if (t != null) {
            movieRepo.delete(titleOfMovie);
        } else {
            throw new StatusException("Filmul nu exista ! ");
        }
    }

    public void updateMovie(String titleOfMovie, int duration) throws StatusException {
        Movie x = findByName(titleOfMovie);
        if (x != null) {
            movieRepo.update(titleOfMovie, duration);
        } else {
            throw new StatusException("Filmul nu exista !");
        }
    }




}
