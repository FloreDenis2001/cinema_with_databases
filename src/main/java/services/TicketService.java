package services;

import exceptii.StatusException;
import model.Ticket;
import repository.TicketRepo;

public class TicketService {
    private TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo2) {
        ticketRepo = ticketRepo2;
    }

    public void addTicket(Ticket x) throws StatusException {
        Ticket t = ticketRepo.findSchedule(x.getSchedules_id());
        if (t == null) {
            ticketRepo.insert(x);
        } else {
            throw new StatusException("Exista acest ticket!");
        }
    }

    public void deleteTicket(int schedules_Id) throws StatusException {
        Ticket t = ticketRepo.findSchedule(schedules_Id);
        if (t != null) {
            ticketRepo.delete(schedules_Id);
        } else {
            throw new StatusException("Nu exista acest ticket ! ");
        }
    }
}
