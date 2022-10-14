package repository;

import model.Ticket;

import java.sql.ResultSet;
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
        String insert = "insert into ticket(user_id,programari_id,amount) values(" + String.format("%d,%d,%f", x.getUser_id(), x.getProgramari_id(), x.getAmount()) + ")";
        executeStatement(insert);
    }

    public void delete(int programareId) {
        String del = String.format("delete from ticket where programari_id=%d",programareId);
        executeStatement(del);
    }

    public List<Ticket> allTickets() {
        executeStatement("select * from ticket");
        List<Ticket> tickets = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                tickets.add(new Ticket(set.getInt(1), set.getInt(2), set.getInt(3), set.getDouble(4)));
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
            if (x.getProgramari_id() == scheduleId)
                return x;
        return null;
    }
}
