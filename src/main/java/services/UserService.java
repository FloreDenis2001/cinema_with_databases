package services;

import exceptii.StatusException;
import model.User;
import repository.UserRepo;

public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo2) {
        userRepo = userRepo2;
    }

    public void addUser(User x) throws StatusException {
        User t = userRepo.findUser(x.getEmail());
        if (t == null) {
            userRepo.insert(x);
        } else {
            throw new StatusException("Exista acest user ! ");
        }
    }

    public void deleteUser(String email, String password) throws StatusException {
        User t = userRepo.findUser(email);
        if (t != null) {
            userRepo.delete(email, password);
        } else {
            throw new StatusException("Nu exista acest user ! ");
        }
    }

    public void updateUser(String email, String oldPassword, String newPassword) throws StatusException {
        User t = userRepo.findUser(email);
        if (t != null) {
            userRepo.update(email, oldPassword, newPassword);
        } else {
            throw new StatusException("Nu exista acest user ! ");
        }
    }


}
