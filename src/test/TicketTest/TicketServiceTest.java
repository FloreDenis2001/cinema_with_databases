package TicketTest;

import exceptii.StatusException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.*;
import services.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {
    private RoomService roomService;
    private RoomRepo roomRepo;
    private MovieRepo movieRepo;
    private MovieService movieService;
    private TicketService ticketService;
    private TicketRepo ticketRepo;
    private ScheduleService scheduleService;
    private ScheduleRepo scheduleRepo;
    private SeatsService seatsService;
    private SeatsRepo seatsRepo;
    private UserRepo userRepo;
    private UserService userService;
    private String database = "cinema_test_db";

    public TicketServiceTest() {
        movieRepo = new MovieRepo(database);
        movieService = new MovieService(movieRepo);
        roomRepo = new RoomRepo(database);
        roomService = new RoomService(roomRepo);
        ticketRepo = new TicketRepo(database);
        ticketService = new TicketService(ticketRepo);
        scheduleRepo = new ScheduleRepo(database);
        scheduleService = new ScheduleService(scheduleRepo);
        seatsRepo = new SeatsRepo(database);
        seatsService = new SeatsService(seatsRepo);
        userRepo = new UserRepo(database);
        userService = new UserService(userRepo);
    }

    @BeforeEach
    public void eraseAll() {
        ticketRepo.eraseAll();
        scheduleRepo.eraseAll();
        seatsRepo.eraseAll();
        userRepo.eraseAll();
        movieRepo.eraseAll();
        roomRepo.eraseAll();
    }

    @Test
    public void addTicket() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);

        User u = new Client("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1");
        userService.addUser(u);

        Ticket l = new Ticket(1, 1, 50.00, 1);
        ticketService.addTicket(l);
        assertEquals(50.00, ticketRepo.findSchedule(1).getAmount());
    }

    @Test
    public void addThrowTicket() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);

        User u = new Client("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1");
        userService.addUser(u);

        Ticket l = new Ticket(1, 1, 50.00, 1);
        ticketService.addTicket(l);
        assertThrows(StatusException.class,()->ticketService.addTicket(l));
    }
    @Test
    public void removeTicket() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);

        User u = new Client("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1");
        userService.addUser(u);

        Ticket l = new Ticket(1, 1, 50.00, 1);
        ticketService.addTicket(l);
        ticketService.deleteTicket(l.getSchedules_id());
        assertEquals(null, ticketRepo.findSchedule(1));
    }

    @Test
    public void removeThrowTicket() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);

        Movie m = new Movie("Thor", "action", 150);
        movieService.addMovie(m);

        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);

        User u = new Client("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1");
        userService.addUser(u);

        Ticket l = new Ticket(1, 1, 50.00, 1);
        ticketService.addTicket(l);
        ticketService.deleteTicket(l.getSchedules_id());
        assertThrows(StatusException.class,()->ticketService.deleteTicket(1));
    }






}