package SchedulesTest;

import model.Movie;
import model.Room;
import model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MovieRepo;
import repository.RoomRepo;
import repository.ScheduleRepo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleRepoTest {
    private ScheduleRepo scheduleRepo;
    private MovieRepo movieRepo;
    private RoomRepo roomRepo;

    public ScheduleRepoTest() {
        scheduleRepo = new ScheduleRepo("cinema_test_db");
        movieRepo = new MovieRepo("cinema_test_db");
        roomRepo = new RoomRepo("cinema_test_db");
    }

    @BeforeEach
    public void eraseAll() {
        scheduleRepo.eraseAll();
        movieRepo.eraseAll();
        roomRepo.eraseAll();
    }

    @Test
    public void insertTest() {
        Room x = new Room("Magic", "vip", 200);
        Movie t = new Movie("Marvel", "action", 120);
        Schedule c = new Schedule(1, 1, LocalDateTime.of(2001, 10, 10, 14, 30));
        movieRepo.insert(t);
        roomRepo.insert(x);
        scheduleRepo.insert(c);
        assertEquals(1, scheduleRepo.findSchedule(1, LocalDateTime.of(2001, 10, 10, 14, 30)).getRoom_id());
    }
    @Test
    public void deleteTest() {
        Room x = new Room("Magic", "vip", 200);
        Movie t = new Movie("Marvel", "action", 120);
        Schedule c = new Schedule(1, 1, LocalDateTime.of(2001, 10, 10, 14, 30));
        movieRepo.insert(t);
        roomRepo.insert(x);
        scheduleRepo.insert(c);
        scheduleRepo.delete(1,LocalDateTime.of(2001, 10, 10, 14, 30));
        assertEquals(null, scheduleRepo.findSchedule(1, LocalDateTime.of(2001, 10, 10, 14, 30)));
    }

}