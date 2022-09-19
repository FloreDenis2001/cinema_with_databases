package SchedulesTest;

import exceptii.StatusException;
import model.Movie;
import model.Room;
import model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MovieRepo;
import repository.RoomRepo;
import repository.ScheduleRepo;
import services.MovieService;
import services.RoomService;
import services.ScheduleService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleServiceTest {
    private ScheduleRepo scheduleRepo;
    private ScheduleService scheduleService;
    private MovieRepo movieRepo;
    private RoomRepo roomRepo;

    public ScheduleServiceTest() {
        scheduleRepo = new ScheduleRepo("cinema_test_db");
        scheduleService = new ScheduleService(scheduleRepo);
        roomRepo = new RoomRepo("cinema_test_db");
        movieRepo = new MovieRepo("cinema_test_db");
    }

    @BeforeEach
    public void eraseAll() {
        scheduleRepo.eraseAll();
        movieRepo.eraseAll();
        roomRepo.eraseAll();
    }

    @Test
    public void addTest() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        RoomService roomService = new RoomService(roomRepo);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        MovieService movieService = new MovieService(movieRepo);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);

        assertEquals(1, scheduleRepo.findSchedule(1, LocalDateTime.of(2022, 9, 12, 20, 10)).getRoom_id());
    }

    @Test
    public void removeTest() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        RoomService roomService = new RoomService(roomRepo);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        MovieService movieService = new MovieService(movieRepo);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);
        scheduleService.deleteSchedules(1, LocalDateTime.of(2022, 9, 12, 20, 10));
        assertEquals(null, scheduleRepo.findSchedule(1, LocalDateTime.of(2022, 9, 12, 20, 10)));
    }

    @Test
    public void addThrow() throws StatusException{
        Room x = new Room("Magic", "Vip", 200);
        RoomService roomService = new RoomService(roomRepo);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        MovieService movieService = new MovieService(movieRepo);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);
        assertThrows(StatusException.class,()->scheduleService.addSchedules(s));
    }

    @Test
    public void deleteThrow() throws StatusException{
        Room x = new Room("Magic", "Vip", 200);
        RoomService roomService = new RoomService(roomRepo);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        MovieService movieService = new MovieService(movieRepo);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);
        assertThrows(StatusException.class,()->scheduleService.deleteSchedules(1, LocalDateTime.of(2022, 9, 12, 20, 20)));

    }


}