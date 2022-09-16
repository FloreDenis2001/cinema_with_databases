package services;

import exceptii.StatusException;
import model.Seats;
import repository.SeatsRepo;

public class SeatsService {
    private SeatsRepo seatsRepo;

    public SeatsService(SeatsRepo seatsRepo2) {
        seatsRepo = seatsRepo2;
    }

    public void addSeat(Seats x)throws StatusException{
        Seats t = seatsRepo.findSeat(x.getRoom_id(),x.getSeatNumber());
        if(t==null){
            seatsRepo.insert(x);
        }else {
            throw new StatusException("Locul este ocupat ! ");
        }
    }

    public void deleteSeat(int room_id,int numberSeat)throws StatusException{
        Seats t = seatsRepo.findSeat(room_id,numberSeat);
        if(t!=null){
            seatsRepo.delete(room_id,numberSeat);
        }else {
            throw new StatusException("Nu exista locul ! ");
        }
    }

}
