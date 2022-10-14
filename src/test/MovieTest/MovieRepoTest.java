package MovieTest;

import model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MovieRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MovieRepoTest {

    private MovieRepo movieRepo;
    private String database="cinema_test_db";


    public MovieRepoTest() {
        this.movieRepo = new MovieRepo(database);
    }

    @BeforeEach
    public void clearTable() {

        this.movieRepo.eraseAll();
    }


    @Test
    public void insertTable() {
        Movie movie = new Movie("hulk", "action", 130);
        movieRepo.insert(movie);
        assertEquals("action", movieRepo.findMovie("hulk").getType());
    }

    @Test
    public void delete() {
        Movie movie = new Movie("Iron Man", "action", 160);
        movieRepo.insert(movie);
        movieRepo.delete("Iron Man");
        assertEquals(null, movieRepo.findMovie("Iron Man"));

    }

    @Test
    public void update() {
        Movie movie = new Movie("Iron Man", "action", 160);
        movieRepo.insert(movie);
        movieRepo.update("Iron Man", 140);
        assertEquals(140, movieRepo.findMovie("Iron Man").getDuration());
    }


    @Test
    public void findByIdTable() {
        Movie movie = new Movie("hulk", "action", 130);
        movieRepo.insert(movie);
        assertEquals(130, movieRepo.movieFindById(1).getDuration());
    }
}