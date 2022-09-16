package MovieTest;

import exceptii.StatusException;
import model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MovieRepo;
import services.MovieService;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    private MovieRepo movieRepo;
    private MovieService movieService;

    public MovieServiceTest() {
        movieRepo = new MovieRepo("cinema_test_db");
        movieService = new MovieService(movieRepo);
    }

    @BeforeEach
    public void eraseAll() {
        movieRepo.eraseAll();
    }

    @Test
    public void addTest() throws StatusException {
        Movie t = new Movie("Thor", "action", 120);
        movieService.addMovie(t);
        assertEquals(120, movieRepo.findMovie("Thor").getDuration());
    }

    @Test
    public void addThrowTest() throws StatusException {
        Movie t = new Movie("Thor", "action", 120);
        Movie x = new Movie("Thor", "action", 160);
        movieService.addMovie(t);
        assertThrows(StatusException.class, () -> movieService.addMovie(x));
    }

    @Test
    public void deleteTest() throws StatusException {
        Movie t = new Movie("Thor", "action", 120);
        movieService.addMovie(t);
        movieService.deleteMovie("Thor");
        assertEquals(null, movieRepo.findMovie("Thor"));
    }

    @Test
    public void deleteTestThrow() throws StatusException {
        Movie t = new Movie("Thor", "action", 120);
        movieService.addMovie(t);
        assertThrows(StatusException.class, () -> movieService.deleteMovie("Thor 2"));
    }

    @Test
    public void updateTest() throws StatusException {
        Movie t = new Movie("Thor", "action", 120);
        movieService.addMovie(t);
        movieService.updateMovie("Thor", 150);
        assertEquals(150, movieRepo.findMovie("Thor").getDuration());
    }

    @Test
    public void updateTestThrow() throws StatusException {
        Movie t = new Movie("Thor", "action", 120);
        movieService.addMovie(t);
        assertThrows(StatusException.class, () -> movieService.updateMovie("Thor 2 ", 150));


    }
}