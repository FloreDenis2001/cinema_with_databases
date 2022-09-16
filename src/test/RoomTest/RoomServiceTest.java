package RoomTest;

import exceptii.StatusException;
import model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.RoomRepo;
import services.RoomService;

import static org.junit.jupiter.api.Assertions.*;

class RoomServiceTest {

    private RoomRepo roomRepo;
    private RoomService roomService;

    public RoomServiceTest() {
        roomRepo = new RoomRepo("cinema_test_db");
        roomService = new RoomService(roomRepo);
    }

    @BeforeEach
    public void eraseAll() {
        roomRepo.eraseAll();
    }

    @Test
    public void addRoomTest() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);
        assertEquals("Vip", roomRepo.findByName("Magic").getType());
    }

    @Test
    public void deleteRoomTest() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);
        roomService.removeRoom(x.getName());
        assertEquals(null, roomRepo.findByName("Magic"));
    }

    @Test
    public void updateRoomTest() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);
        roomService.updateRoom("Magic", 150);
        assertEquals(150, roomRepo.findByName("Magic").getMax_seats());
    }


    @Test
    public void addRoomThrow() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);
        assertThrows(StatusException.class, () -> roomService.addRoom(x));
    }

    @Test
    public void deleteRoomThrowTest() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);
        assertThrows(StatusException.class, () -> roomService.removeRoom("magic2"));
    }

    @Test
    public void updateRoomThrowTest() throws StatusException {
        Room x = new Room("Magic", "Vip", 200);
        roomService.addRoom(x);
        assertThrows(StatusException.class,()->roomService.updateRoom("olaf",150));
    }


}