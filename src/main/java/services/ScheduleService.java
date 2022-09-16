package services;

import exceptii.StatusException;
import model.Movie;
import model.Room;
import model.Schedule;
import repository.MovieRepo;
import repository.RoomRepo;
import repository.ScheduleRepo;

import java.time.LocalDateTime;

public class ScheduleService {
    private ScheduleRepo scheduleRepo;

    public ScheduleService(ScheduleRepo scheduleRepo2) {
        scheduleRepo = scheduleRepo2;
    }

    public void addSchedules(Schedule t) throws StatusException {
        Schedule x = scheduleRepo.findSchedule(t.getRoom_id(),t.getStartTime());
        if(x==null){
            scheduleRepo.insert(t);
        }else {
            throw new StatusException("Aceasta programare este exista !");
        }
    }


    public void deleteSchedules(int room_id,LocalDateTime time) throws StatusException{
        Schedule x = scheduleRepo.findSchedule(room_id,time);
        if(x!=null){
            scheduleRepo.delete(room_id,time);
        }else {
            throw new StatusException("Aceasta programare nu exista !");
        }
    }
}
