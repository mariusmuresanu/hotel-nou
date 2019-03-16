package UI;

import Domain.CheckIn;
import Domain.RoomAverageRatingViewModel;
import Service.CheckInService;

import java.util.Scanner;

public class Console {
    private CheckInService service;
    private Scanner scanner;

    public Console(CheckInService service){
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu(){
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. Rating pe camera");
        System.out.println("a. Afisare toate cazarile");
        System.out.println("x. Iesire");
    }

    public void run(){
        while (true){
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleCheckIn();
            }else if(option.equals("2")) {
                handleCheckOut();
            }else if (option.equals("4")){
                handleRoomRating();
            }else if (option.equals("a")){
                handleShowAll();
            }else if (option.equals("x")){
                break;
            }
        }
    }


    private void handleRoomRating(){
    for (RoomAverageRatingViewModel roomAverage : service.getRoomRatingAverage())
        System.out.println(roomAverage);
    }

    private void handleCheckOut(){
        try {
            System.out.println("Dati numarul camerei:");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati un feedback:");
            String feedback = scanner.nextLine();
            System.out.println("Dati un rating:");
            int rating = Integer.parseInt(scanner.nextLine());

            service.exitRoom(roomNumber, feedback, rating);

        }catch (RuntimeException runtimeException){
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
    private void handleShowAll(){
        for (CheckIn c : service.getAll())
            System.out.println(c);
    }

    private void handleCheckIn(){
        try {
            System.out.println("Dati Id-ul:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de persoane:");
            int persNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati camera:");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de zile:");
            int daysNumber = Integer.parseInt(scanner.nextLine());
            service.enterRoom(id, persNumber, roomNumber, daysNumber);
        }catch (RuntimeException runtimeException){
            System.out.println("Avem erori: "  +  runtimeException.getMessage());
        }
    }
}
