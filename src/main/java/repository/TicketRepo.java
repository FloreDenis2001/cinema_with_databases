package repository;

import model.Schedule;
import model.Ticket;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketRepo extends Repository {

    public TicketRepo(String database) {
        super(database);
    }

    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate ticket";
        executeStatement(eraseAll);

    }

    @Override
    public void insert(Object o) {
        Ticket x = (Ticket) o;
        String insert = "insert into ticket(schedules_id,user_id,amount,seat_id) values(" + String.format("%d,%d,%f,%d", x.getSchedules_id(), x.getUser_id(), x.getAmount(), x.getSeat_id()) + ")";
        executeStatement(insert);
    }

    public void delete(int scheduleId) {
        String del = String.format("delete from ticket where schedules_id=%d", scheduleId);
        executeStatement(del);
    }

    public List<Ticket> allTickets() {
        executeStatement("select * from ticket");
        List<Ticket> tickets = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                tickets.add(new Ticket(set.getInt(1), set.getInt(2), set.getInt(3), set.getDouble(4), set.getInt(5)));
            }
            return tickets;
        } catch (Exception e) {
            System.out.println("ERROR schita nu exista !");
            return null;
        }
    }

    public Ticket findSchedule(int scheduleId) {
        List<Ticket> tickets = allTickets();
        for (Ticket x : tickets)
            if (x.getSchedules_id() == scheduleId)
                return x;
        return null;
    }
}
