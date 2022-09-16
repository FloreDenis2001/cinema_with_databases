package TicketTest;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepoTest {
    private TicketRepo ticketRepo;
    private ScheduleRepo scheduleRepo;
    private UserRepo userRepo;
    private MovieRepo movieRepo;
    private RoomRepo roomRepo;
    private SeatsRepo seatsRepo;

    public TicketRepoTest() {
        ticketRepo = new TicketRepo("cinema_test_db");
        scheduleRepo = new ScheduleRepo("cinema_test_db");
        userRepo = new UserRepo("cinema_test_db");
        movieRepo = new MovieRepo("cinema_test_db");
        roomRepo = new RoomRepo("cinema_test_db");
        seatsRepo = new SeatsRepo("cinema_test_db");
    }

    @BeforeEach
    public void eraseAll() {
        ticketRepo.eraseAll();
        scheduleRepo.eraseAll();
        userRepo.eraseAll();
        movieRepo.eraseAll();
        roomRepo.eraseAll();
        seatsRepo.eraseAll();
    }


    @Test
    public void insert() {
        Room x = new Room("Magic", "vip", 200);
        Movie t = new Movie("Marvel", "action", 120);
        Schedule c = new Schedule(1, 1, LocalDateTime.of(2001, 10, 10, 14, 30));
        Seats s = new Seats(1, 20);
        User u = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        movieRepo.insert(t);
        roomRepo.insert(x);
        scheduleRepo.insert(c);
        seatsRepo.insert(s);
        userRepo.insert(u);
        Ticket l = new Ticket(1, 1, 50.00, 1);
        ticketRepo.insert(l);
        assertEquals(50.00, ticketRepo.findSchedule(1).getAmount());
    }

    @Test
    public void delete() {
        Room x = new Room("Magic", "vip", 200);
        Movie t = new Movie("Marvel", "action", 120);
        Schedule c = new Schedule(1, 1, LocalDateTime.of(2001, 10, 10, 14, 30));
        Seats s = new Seats(1, 20);
        User u = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        movieRepo.insert(t);
        roomRepo.insert(x);
        scheduleRepo.insert(c);
        seatsRepo.insert(s);
        userRepo.insert(u);
        Ticket l = new Ticket(1, 1, 50.00, 1);
        ticketRepo.insert(l);
        ticketRepo.delete(1);
        assertEquals(null, ticketRepo.findSchedule(1));
    }

}