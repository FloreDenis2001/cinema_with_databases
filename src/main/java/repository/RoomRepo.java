package repository;

import model.Room;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomRepo extends Repository {
    public RoomRepo(String database) {
        super(database);
    }

    public void eraseAll() {
        String check = "SET FOREIGN_KEY_CHECKS = 0";
        executeStatement(check);
        String eraseAll = "truncate room";
        executeStatement(eraseAll);
        String check2 = "SET FOREIGN_KEY_CHECKS = 1";
        executeStatement(check2);
    }

    @Override
    public void insert(Object o) {
        Room x = (Room) o;
        String insert = "insert into  room (name,type,max_seats) values(" + String.format("'%s','%s',%d", x.getName(), x.getType(), x.getMax_seats()) + ")";
        executeStatement(insert);
    }

    public void delete(String nameOfRoom) {
        String delete = String.format("delete from room where name='%s'", nameOfRoom);
        executeStatement(delete);
    }

    public void update(String name, int max_seats_update) {
        String update = String.format("update room set max_seats=%d where name='%s'", max_seats_update, name);
        executeStatement(update);
    }


    public List<Room> allRooms() {
        executeStatement("select * from room");
        List<Room> rooms = new ArrayList<>();
        try {
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                rooms.add(new Room(set.getString(2),set.getString(3),set.getInt(4)));
            }
            return rooms;
        } catch (Exception e) {
            System.out.println("ERROR schita nu exista !");
            return null;
        }
    }

    public Room findByName(String name) {
        List<Room> rooms = allRooms();
        for (Room x : rooms)
            if (x.getName().compareTo(name) == 0)
                return x;


        return null;
    }


}
