package MovieTest;

import model.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MovieRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MovieRepoTest {

    private MovieRepo movieRepo2;

    public MovieRepoTest() {
        this.movieRepo2 = new MovieRepo("cinema_test_db");
    }

    @BeforeEach
    public void clearTable() {
        this.movieRepo2.eraseAll();
    }


    @Test
    public void insertTable() {
        Movie movie = new Movie("hulk", "action", 130);
        movieRepo2.insert(movie);
        assertEquals("action", movieRepo2.findMovie("hulk").getType());
    }

    @Test
    public void delete() {
        Movie movie = new Movie("Iron Man", "action", 160);
        movieRepo2.insert(movie);
        movieRepo2.delete("Iron Man");
        assertEquals(null, movieRepo2.findMovie("Iron Man"));

    }

    @Test
    public void update() {
        Movie movie = new Movie("Iron Man", "action", 160);
        movieRepo2.insert(movie);
        movieRepo2.update("Iron Man", 140);
        assertEquals(140, movieRepo2.findMovie("Iron Man").getDuration());
    }


    @Test
    public void findByIdTable() {
        Movie movie = new Movie("hulk", "action", 130);
        movieRepo2.insert(movie);
        assertEquals(130, movieRepo2.movieFindById(1).getDuration());
    }
}