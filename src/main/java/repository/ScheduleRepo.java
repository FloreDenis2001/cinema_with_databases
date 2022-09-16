package repository;

import model.Schedule;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepo extends Repository{
    public ScheduleRepo(String database) {
        super(database);
    }

    @Override
    public void insert(Object o) {
        Schedule x= (Schedule) o;
        String insert = "insert into schedules (room_id, movie_id, startTime) values("+String.format("%d,%d,'%s'",x.getRoom_id(),x.getMovie_id(),x.getStartTime())+")";
        executeStatement(insert);
    }


    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate schedules";
        executeStatement(eraseAll);

    }


    public void delete(int room_id,LocalDateTime time) {
        String delete = String.format("delete from schedules where room_id=%d && startTime='%s'",room_id,time);
        executeStatement(delete);
    }


    public List<Schedule> allSchedules() {
        executeStatement("select * from schedules");
        List<Schedule> schedules = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                schedules.add(new Schedule(set.getInt(1),set.getInt(2),set.getInt(3),set.getTimestamp(4).toLocalDateTime()));
            }
            return schedules;
        } catch (Exception e) {
            System.out.println("ERROR schita nu exista !");
            return null;
        }
    }

    public Schedule findSchedule(int room_id, LocalDateTime time) {
        List<Schedule> schedules = allSchedules();
        for (Schedule x : schedules)
            if (x.getRoom_id()==room_id && x.getStartTime().compareTo(time)==0)
                return x;
        return null;
    }
}
