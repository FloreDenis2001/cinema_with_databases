package repository;

import model.Ticket;

public class TicketRepo extends Repository {

    public TicketRepo(String database) {
        super(database);
    }

    @Override
    public void insert(Object o) {
        Ticket x = (Ticket)  o;
        String insert = "insert into ticket(schedules_id,user_id,amount,seat_id) values("+String.format("%d,%d,%f,%d",x.getSchedules_id(),x.getUser_id(),x.getAmount(),x.getSeat_id())+")";
        executeStatement(insert);
    }
}
