package SeatsTest;

import exceptii.StatusException;
import model.Room;
import model.Seats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.RoomRepo;
import repository.SeatsRepo;
import services.RoomService;
import services.SeatsService;

import static org.junit.jupiter.api.Assertions.*;

class SeatsServiceTest {
    private SeatsService seatsService;
    private SeatsRepo seatsRepo;
    private RoomRepo roomRepo;
    private RoomService roomService;

    public SeatsServiceTest() {
        seatsRepo = new SeatsRepo("cinema_test_db");
        seatsService = new SeatsService(seatsRepo);
        roomRepo = new RoomRepo("cinema_test_db");
        roomService = new RoomService(roomRepo);
    }

    @BeforeEach
    public void eraseAll() {
        seatsRepo.eraseAll();
        roomRepo.eraseAll();
    }

    @Test
    public void addTest() throws StatusException {
        Seats x = new Seats(1, 20);
        Room t = new Room("Magic", "Vip", 200);
        roomService.addRoom(t);
        seatsService.addSeat(x);
        assertEquals(20,seatsRepo.findSeat(1,20).getSeatNumber());
    }

    @Test
    public void addThrowTest() throws StatusException {
        Seats x = new Seats(1, 20);
        Room t = new Room("Magic", "Vip", 200);
        roomService.addRoom(t);
        seatsService.addSeat(x);
        assertThrows(StatusException.class,()->seatsService.addSeat(x));
    }

    @Test
    public void deleteTest() throws StatusException{
        Seats x = new Seats(1, 20);
        Room t = new Room("Magic", "Vip", 200);
        roomService.addRoom(t);
        seatsService.addSeat(x);
        seatsService.deleteSeat(1,20);
        assertEquals(null,seatsRepo.findSeat(1,20));
    }

    @Test
    public void deleteThrowTest() throws StatusException{
        Seats x = new Seats(1, 20);
        Room t = new Room("Magic", "Vip", 200);
        roomService.addRoom(t);
        seatsService.addSeat(x);
       assertThrows(StatusException.class,()-> seatsService.deleteSeat(1,30));
    }

}