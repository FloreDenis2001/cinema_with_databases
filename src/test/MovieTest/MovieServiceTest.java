package MovieTest;

import exceptii.StatusException;
import model.Movie;
import model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MovieRepo;
import repository.RoomRepo;
import services.MovieService;
import services.RoomService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    private MovieRepo movieRepo;
    private MovieService movieService;
    private RoomService roomService;
    private RoomRepo roomRepo;
    private String databases="cinema_test_db";

    public MovieServiceTest() {
        movieRepo = new MovieRepo(databases);
        movieService = new MovieService(movieRepo);
        roomRepo=new RoomRepo(databases);
        roomService=new RoomService(roomRepo);
    }

    @BeforeEach
    public void eraseAll() {
        movieRepo.eraseAll();
        roomRepo.eraseAll();
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

    @Test
    public void finishTimeTest() throws StatusException {
        Movie m = new Movie("Thor", "action", 150);
        movieService.addMovie(m);

        Room x = new Room("Magic", "vip", 200);
        roomService.addRoom(x);



    }

}