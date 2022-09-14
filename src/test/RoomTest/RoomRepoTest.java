package RoomTest;

import model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.RoomRepo;

import static org.junit.jupiter.api.Assertions.*;

class RoomRepoTest {
    private RoomRepo roomRepo;

    public RoomRepoTest(){
        this.roomRepo=new RoomRepo("cinema_test_db");
    }

    @BeforeEach
    public void clearAll(){
        this.roomRepo.eraseAll();
    }

    @Test
    public void insert(){
        Room x = new Room("Magic","VIP",200);
        roomRepo.insert(x);
        assertEquals(200,roomRepo.findByName("Magic").getMax_seats());
    }

    @Test
    public void delete(){
        Room x = new Room("World","Supreme",50);
        roomRepo.insert(x);
        roomRepo.delete("World");
        assertEquals(null,roomRepo.findByName("World"));
    }

    @Test
    public void update(){
        Room x = new Room("World","Supreme",50);
        roomRepo.insert(x);
        roomRepo.update("World",80);
        assertEquals(80,roomRepo.findByName("World").getMax_seats());
    }



}