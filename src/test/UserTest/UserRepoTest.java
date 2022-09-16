package UserTest;

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
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userRepo.insert(x);
        assertEquals("client", userRepo.findUser("floredenis907@yahoo.com").getRoles());
    }

    @Test
    public void deleteTest() {
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userRepo.insert(x);
        userRepo.delete(x.getEmail(), x.getPassword());
        assertEquals(null, userRepo.findUser("floredenis907@yahoo.com"));
    }

    @Test
    public void updateTest() {
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userRepo.insert(x);
        userRepo.update("floredenis907@yahoo.com", "parola1", "parola2");
        assertEquals("parola2", userRepo.findUser("floredenis907@yahoo.com").getPassword());
    }




}