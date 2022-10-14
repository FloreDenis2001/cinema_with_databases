package ProgramareTest;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramareRepoTest {

    private ProgramareRepo programareRepo;
    private RoomRepo roomRepo;
    private SeatsRepo seatsRepo;
    private MovieRepo movieRepo;
    private String database = "cinema_test_db";

    ProgramareRepoTest() {
        this.programareRepo = new ProgramareRepo(database);
        this.roomRepo = new RoomRepo(database);
        this.seatsRepo = new SeatsRepo(database);
        this.movieRepo = new MovieRepo(database);
    }

    @BeforeEach
    public void eraseAll() {
        programareRepo.eraseAll();
        roomRepo.eraseAll();
        seatsRepo.eraseAll();
        movieRepo.eraseAll();
    }

    @Test
    public void eraseAll2() {
        programareRepo.eraseAll();
        roomRepo.eraseAll();
        seatsRepo.eraseAll();
        movieRepo.eraseAll();
    }

    @Test
    public void addTest() {
        Room x = new Room("Magic", "3D", 150);
        this.roomRepo.insert(x);
        Seats t = new Seats(1, 20);
        this.seatsRepo.insert(t);
        Movie m = new Movie("Thor", "Action", 170);
        this.movieRepo.insert(m);
        LocalDateTime lo = LocalDateTime.of(2001, 10, 10, 14, 30);
        Programare p = new Programare(1, 1, 1, lo, lo.plusMinutes(160));
        this.programareRepo.insert(p);
        assertEquals(17, this.programareRepo.programareFindById(1).getFinishTime().getHour());
    }

    @Test
    public void removeTest() {
        Room x = new Room("Magic", "3D", 150);
        this.roomRepo.insert(x);
        Seats t = new Seats(1, 20);
        this.seatsRepo.insert(t);
        Movie m = new Movie("Thor", "Action", 170);
        this.movieRepo.insert(m);
        Programare p = new Programare(1, 1, 1, LocalDateTime.of(2001, 10, 10, 14, 30), LocalDateTime.of(2001, 10, 10, 14, 30).plusMinutes(160));
        this.programareRepo.insert(p);
        this.programareRepo.deleteProgramareByRoomIdAndSeat(1, 1);
        assertEquals(null, this.programareRepo.programareFindById(1));
    }

    @Test
    public void allMovies() {
        Room x = new Room("Magic", "3D", 150);
        Room x1 = new Room("Oxy", "2D", 110);
        Room x2 = new Room("Low", "4k", 100);
        this.roomRepo.insert(x);
        this.roomRepo.insert(x1);
        this.roomRepo.insert(x2);
        Seats t = new Seats(1, 20);
        this.seatsRepo.insert(t);
        Movie m = new Movie("Thor", "Action", 150);
        Movie m1 = new Movie("Thor 2", "Action", 140);
        Movie m2 = new Movie("Thor 3", "Action", 100);
        this.movieRepo.insert(m);
        this.movieRepo.insert(m1);
        this.movieRepo.insert(m2);
        Programare p = new Programare(1, 1, 1, LocalDateTime.of(2001, 10, 10, 14, 30),LocalDateTime.of(2001, 10, 10, 14, 30).plusMinutes(160));
        Programare p1 = new Programare(3, 2, 1, LocalDateTime.of(2001, 10, 10, 17, 30), LocalDateTime.of(2001, 10, 10, 17, 30).plusMinutes(160));
        Programare p2 = new Programare(2, 3, 1, LocalDateTime.of(2001, 10, 10, 12, 30), LocalDateTime.of(2001, 10, 10, 12, 30).plusMinutes(160));
        Programare p3 = new Programare(2, 2, 1, LocalDateTime.of(2011, 10, 10, 12, 30), LocalDateTime.of(2011, 10, 10, 12, 30).plusMinutes(160));
        this.programareRepo.insert(p);
        this.programareRepo.insert(p1);
        this.programareRepo.insert(p2);

        List<Programare> programareList=programareRepo.listOfTheDayByRoom(LocalDate.of(2001, 10, 10));
        for (Programare y:programareList){
            System.out.println(y);
        }
    }


}