package SeatsTest;

import model.Room;
import model.Seats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.RoomRepo;
import repository.SeatsRepo;

import static org.junit.jupiter.api.Assertions.*;

class SeatsRepoTest {
    private SeatsRepo seatsRepo;
    private RoomRepo roomRepo;
    public SeatsRepoTest() {
        seatsRepo = new SeatsRepo("cinema_test_db");
        roomRepo=new RoomRepo("cinema_test_db");
    }


    @BeforeEach
    public void eraseAll() {
        this.seatsRepo.eraseAll();
        this.roomRepo.eraseAll();

    }

    @Test
    public void insertTest(){
        Room t=new Room(1,"Magic","vip",300);
        this.roomRepo.insert(t);
        Seats x = new Seats(1,150);
        this.seatsRepo.insert(x);
        assertEquals(150,this.seatsRepo.findSeat(1,150).getSeatNumber());
    }

    @Test
    public void deleteTest(){
        eraseAll();
        Room t=new Room("Magic","vip",200);
        this.roomRepo.insert(t);
        Seats x = new Seats(1,150);
        this.seatsRepo.insert(x);
        seatsRepo.delete(x.getRoom_id(),x.getSeatNumber());
        assertEquals(null,seatsRepo.findSeat(1,150));

    }
}