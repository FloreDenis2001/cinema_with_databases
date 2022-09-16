package services;

import exceptii.StatusException;
import model.Room;
import repository.RoomRepo;

public class RoomService {
    private RoomRepo roomRepo;

    public RoomService(RoomRepo roomRepo2){
        roomRepo=roomRepo2;
    }

    public void addRoom(Room t)throws StatusException{
        Room x = roomRepo.findByName(t.getName());
        if(x==null){
            roomRepo.insert(t);
        }else {
            throw new StatusException("Camera exista deja ! ");
        }
    }
    public void removeRoom(String nameOfRoom)throws StatusException{
        Room x = roomRepo.findByName(nameOfRoom);
        if(x!=null){
            roomRepo.delete(nameOfRoom);
        }else {
            throw new StatusException("Camera nu exista deja ! ");
        }
    }

    public void updateRoom(String nameOfRoom,int max_seat_update)throws StatusException{
        Room x = roomRepo.findByName(nameOfRoom);
        if(x!=null){
            roomRepo.update(nameOfRoom,max_seat_update);
        }else {
            throw new StatusException("Camera nu exista deja ! ");
        }
    }


}
