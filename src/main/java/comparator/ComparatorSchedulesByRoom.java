package comparator;

import model.Schedule;

import java.time.LocalDateTime;
import java.util.Comparator;

public class ComparatorSchedulesByRoom implements Comparator<Schedule> {
    @Override
    public int compare(Schedule o1, Schedule o2) {
        return o1.getStartTime().compareTo(o2.getStartTime());
    }
}
