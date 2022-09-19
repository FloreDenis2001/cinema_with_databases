import exceptii.StatusException;
import model.Movie;
import model.Room;
import model.Schedule;
import model.Seats;
import repository.MovieRepo;
import repository.RoomRepo;
import repository.ScheduleRepo;
import repository.SeatsRepo;
import services.MovieService;
import services.RoomService;
import services.ScheduleService;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) throws StatusException {


        String database = "cinema_test_db";
        LocalDateTime startTime = LocalDateTime.of(2022, 9, 12, 20, 10);
        int movie_id = 1;
        MovieService movieService = new MovieService(new MovieRepo(database));
        Movie m = new Movie("Thor", "action", 150);
        movieService.addMovie(m);

        RoomService roomService = new RoomService(new RoomRepo(database));
        Room x = new Room("Magic", "vip", 200);
        roomService.addRoom(x);

        ScheduleService scheduleService = new ScheduleService(new ScheduleRepo(database));
        Schedule s = new Schedule(1, 1, LocalDateTime.of(2022, 9, 12, 20, 10));
        scheduleService.addSchedules(s);

        MovieRepo movieRepo=new MovieRepo(database);
        Movie t = movieRepo.movieFindById(movie_id);
        LocalDateTime finishTime = startTime.plusMinutes(t.getDuration());
        System.out.println(finishTime);
    }
}
