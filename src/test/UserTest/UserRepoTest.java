package UserTest;

import model.Client;
import model.Staff;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepo;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {
    private UserRepo userRepo;

    public UserRepoTest() {
        userRepo = new UserRepo("cinema_test_db");
    }

    @BeforeEach
    public void eraseAll() {
        userRepo.eraseAll();
    }

    @Test
    public void insertTest() {
        User t = new Client("Flore","Denis",20,"floredenis@yahoo.com","parola1");
        userRepo.insert(t);
        assertEquals(20, userRepo.findUser("floredenis@yahoo.com").getAge());
    }


    @Test
    public void deleteTest() {
        User x = new Staff("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1","Moderator");
        userRepo.insert(x);
        userRepo.delete(x.getEmail(), x.getPassword());
        assertEquals(null, userRepo.findUser("floredenis907@yahoo.com"));
    }

    @Test
    public void updateTest() {
        User x = new Staff("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1","Moderator");
        userRepo.insert(x);
        userRepo.update("floredenis907@yahoo.com", "parola1", "parola2");
        assertEquals("parola2", userRepo.findUser("floredenis907@yahoo.com").getPassword());
    }






}