package TicketTest;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepoTest {
    private TicketRepo ticketRepo;
    private ProgramareRepo programareRepo;
    private UserRepo userRepo;
    private MovieRepo movieRepo;
    private RoomRepo roomRepo;
    private SeatsRepo seatsRepo;
    private String database="cinema_test_db";

    public TicketRepoTest() {
        ticketRepo = new TicketRepo(database);
        programareRepo=new ProgramareRepo(database);
        userRepo = new UserRepo(database);
        movieRepo = new MovieRepo(database);
        roomRepo = new RoomRepo(database);
        seatsRepo = new SeatsRepo(database);
    }

    @BeforeEach
    public void eraseAll() {
        ticketRepo.eraseAll();
        programareRepo.eraseAll();
        userRepo.eraseAll();
        movieRepo.eraseAll();
        roomRepo.eraseAll();
        seatsRepo.eraseAll();
    }


    @Test
    public void insert() {
        Room x = new Room("Magic", "vip", 200);
        Movie t = new Movie("Marvel", "action", 120);
        Seats s = new Seats(1, 20);
        Programare c = new Programare(1,1, 1, LocalDateTime.of(2001, 10, 10, 14, 30),LocalDateTime.of(2001, 10, 10, 14, 30).plusMinutes(160));

        User u = new Client("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1");
        movieRepo.insert(t);
        roomRepo.insert(x);
        programareRepo.insert(c);
        seatsRepo.insert(s);
        userRepo.insert(u);
        Ticket l = new Ticket(1, 1, 50.00);
        ticketRepo.insert(l);
        assertEquals(50.00, ticketRepo.findSchedule(1).getAmount());
    }

    @Test
    public void delete() {
        Room x = new Room("Magic", "vip", 200);
        Movie t = new Movie("Marvel", "action", 120);
        Seats s = new Seats(1, 20);
        Programare c = new Programare(1,1, 1, LocalDateTime.of(2001, 10, 10, 14, 30),LocalDateTime.of(2001, 10, 10, 14, 30).plusMinutes(160));
        User u = new Client("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1");
        movieRepo.insert(t);
        roomRepo.insert(x);
        programareRepo.insert(c);
        seatsRepo.insert(s);
        userRepo.insert(u);
        Ticket l = new Ticket(1,1, 50.00);
        ticketRepo.insert(l);
        ticketRepo.delete(1);
        assertEquals(null, ticketRepo.findSchedule(1));
    }
}