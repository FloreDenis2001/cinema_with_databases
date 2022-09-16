package repository;

import model.Room;
import model.Seats;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeatsRepo extends Repository {
    public SeatsRepo(String database) {
        super(database);
    }


    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate seats";
        executeStatement(eraseAll);
    }

    @Override
    public void insert(Object o) {
        Seats x = (Seats) o;
        String insert = "insert into  seats (room_id,seatNumber) values(" + String.format("%d,%d", x.getRoom_id(),x.getSeatNumber()) + ")";
        executeStatement(insert);
    }


    public void delete(int room_id ,int seatNumber) {
        String delete = String.format("delete from seats where (seatNumber=%d AND room_id=%d)", seatNumber,room_id);
        executeStatement(delete);
    }


    public List<Seats> allSeats() {
        executeStatement("select * from seats");
        List<Seats> seats = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                seats.add(new Seats(set.getInt(2), set.getInt(3)));
            }
            return seats;
        } catch (Exception e) {
            System.out.println("ERROR schita nu exista !");
            return null;
        }
    }

    public Seats findSeat(int room_id, int numberofseats) {
        List<Seats> seats = allSeats();
        for (Seats x : seats)
            if (x.getRoom_id() == room_id && x.getSeatNumber()==numberofseats)
                return x;
        return null;
    }

}
