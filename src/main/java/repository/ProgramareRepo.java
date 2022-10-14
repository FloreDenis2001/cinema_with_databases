package repository;

import model.Programare;
import utile.Utile;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProgramareRepo extends Repository{

    public ProgramareRepo(String database) {
        super(database);
    }
    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate programari";
        executeStatement(eraseAll);

    }
    @Override
    public void insert(Object o) {
        Programare t =(Programare) o;
        String insert = "insert into programari (movie_id,room_id,seats_id,startTime,finishTime) values("+String.format("%d,%d,%d,'%s','%s'",t.getMovie_id(),t.getRoom_id(),t.getSeats_id(),t.getStartTime(),t.getFinishTime())+")";
        executeStatement(insert);
    }


    public void deleteProgramareByRoomIdAndSeat(int room_id, int seat_id){
        String delete=String.format("delete from programari where (room_id=%d and seats_id=%d)",room_id,seat_id);
        executeStatement(delete);
    }
    public List<Programare> allProgramas() {
        executeStatement("select * from programari");
        List<Programare> programares = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                programares.add(new Programare(set.getInt(2), set.getInt(3), set.getInt(4), set.getTimestamp(5).toLocalDateTime(),set.getTimestamp(6).toLocalDateTime()));
            }
            return programares;
        } catch (Exception e) {
            System.out.println("ERROR schita nu exista !");
            return null;
        }
    }

    public Programare programareFindById(int id) {
        String findProgramare = String.format("select * from programari where id=%d",id);
        executeStatement(findProgramare);
        List<Programare> programares = new ArrayList<>();

        try {
            ResultSet set = statement.getResultSet();
            while(set.next()){
                programares.add(new Programare(set.getInt(1), set.getInt(2), set.getInt(3), set.getInt(4), set.getTimestamp(5).toLocalDateTime(),set.getTimestamp(6).toLocalDateTime()));
            }

            return programares.get(0);
        } catch (Exception e) {
            System.out.println("Nu exista programarea respectiva");
        }
        return null;
}

    public List<Programare> listOfTheDayByRoom(LocalDate time) {
        String timeStart = Utile.convertLocalDateTimeToSqlTimeStamp(time);
        String finishTime = Utile.convertLocalDateTimeToSql(time);
        String select = String.format("select * from programari where startTime>'%s' and finishTime<'%s'",timeStart,finishTime);

        executeStatement(select);
        List<Programare> list = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                list.add(new Programare(set.getInt(1), set.getInt(2), set.getInt(3), set.getInt(4), set.getTimestamp(5).toLocalDateTime(),set.getTimestamp(6).toLocalDateTime()));
            }
            return list;
        } catch (Exception e) {
            System.out.println("Nu exista aceasta camera");
        }
        return null;
    }



}
