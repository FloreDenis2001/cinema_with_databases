package view;

import model.Client;
import model.User;
import repository.*;
import services.*;

import java.util.Scanner;

public class ViewClient {
    private MovieService movieService;
    private RoomService roomService;
    private ScheduleService scheduleService;
    private TicketService ticketService;
    private UserService userService;
    private SeatsService seatsService;
    private Client client;
    private Scanner scanner;
    private String database="cinema_db";
    public ViewClient(Client clientele){
        this.client=clientele;
        movieService=new MovieService(new MovieRepo(database));
        roomService=new RoomService(new RoomRepo(database));
        scheduleService=new ScheduleService(new ScheduleRepo(database));
        ticketService=new TicketService(new TicketRepo(database));
        userService=new UserService(new UserRepo(database));
        this.scanner=new Scanner(System.in);
    }



    public void meniu() {
        System.out.println("---------------------Meniu------------------");
        System.out.println("1. Pentru a vedea toate filmele din cinema");
        System.out.println("2. Pentru a vedea filmele care ruleaza in ziua respectiva");
        System.out.println("3. Pentru a cumpara un bilet");
        System.out.println("--------------------------------------------");

    }

    public void play() {
        boolean running = true;
        int choose;

        while (running) {
            meniu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1: movieService.printAllMovie();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    meniu();
            }
        }
    }


}
