package services;

import exceptii.StatusException;
import model.Movie;
import model.Room;
import model.Schedule;
import repository.MovieRepo;
import repository.Programare;
import repository.RoomRepo;
import repository.ScheduleRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeSet;

public class ScheduleService {
    private ScheduleRepo scheduleRepo;
    private MovieRepo movieRepo;
    private String database;

    public ScheduleService(ScheduleRepo scheduleRepo2) {
        scheduleRepo = scheduleRepo2;
    }

    public void addSchedules(Schedule t) throws StatusException {
        Schedule x = scheduleRepo.findSchedule(t.getRoom_id(), t.getStartTime());
        TreeSet<Programare> programareTreeSet = totalProgramari();
        for (Programare p : programareTreeSet) {
            if (p.getStartTime().compareTo(movieRepo.finishTime(t.getMovie_id(), t.getStartTime())) > 0 && p.getFinishTime().compareTo(t.getStartTime()) < 0) {
                if (x == null) {
                    scheduleRepo.insert(t);
                } else {
                    throw new StatusException("Aceasta programare este exista !");
                }
            }
        }
    }


    public TreeSet<Programare> totalProgramari() {
        List<Schedule> schedules = scheduleRepo.allSchedules();
        TreeSet<Programare> programareTreeSet = new TreeSet<>();
        for (Schedule s : schedules) {
            programareTreeSet.add(new Programare(s.getStartTime(), movieRepo.finishTime(s.getMovie_id(), s.getStartTime())));
        }
        return programareTreeSet;
    }

    public void deleteSchedules(int room_id, LocalDateTime time) throws StatusException {
        Schedule x = scheduleRepo.findSchedule(room_id, time);
        if (x != null) {
            scheduleRepo.delete(room_id, time);
        } else {
            throw new StatusException("Aceasta programare nu exista !");
        }
    }


    public void verifyProgram() {
        List<Schedule> schedules = scheduleRepo.allSchedules();
    }
}
