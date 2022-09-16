package UserTest;

import exceptii.StatusException;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepo;
import services.UserService;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private UserRepo userRepo;

    public UserServiceTest() {
        userRepo = new UserRepo("cinema_test_db");
        userService = new UserService(userRepo);
    }

    @BeforeEach
    public void eraseAll() {
        userRepo.eraseAll();
    }

    @Test
    public void addTest() throws StatusException {
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userService.addUser(x);
        assertEquals("client",userRepo.findUser(x.getEmail()).getRoles());
    }

    @Test
    public void addThrowTest() throws StatusException{
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userService.addUser(x);
        assertThrows(StatusException.class,()->userService.addUser(x));
    }

    @Test
    public void deleteTest() throws StatusException{
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userService.addUser(x);
        userService.deleteUser(x.getEmail(),x.getPassword());
        assertEquals(null,userRepo.findUser(x.getEmail()));
    }

    @Test
    public void deleteThrowTest() throws StatusException{
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userService.addUser(x);
        assertThrows(StatusException.class,()->userService.deleteUser("denis@yahoo.com",x.getPassword()));
    }

    @Test
    public void updateTest() throws StatusException{
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userService.addUser(x);
        userService.updateUser(x.getEmail(),x.getPassword(),"denis2001");
        assertEquals("denis2001",userRepo.findUser(x.getEmail()).getPassword());
    }

    @Test
    public void updateThrowTest() throws StatusException{
        User x = new User("Denis", "Flore", 20, "floredenis907@yahoo.com", "parola1", "client");
        userService.addUser(x);
        assertThrows(StatusException.class,()->userService.updateUser("denis@yahoo.com",x.getPassword(),"denis2001"));
    }

}