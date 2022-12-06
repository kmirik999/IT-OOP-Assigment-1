import java.io.IOException;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String selection;
        String data;
        String flightNumber;
        String place;
        String user;
        int hashID;
        DataInputReader.readOneFile();
        System.out.println("COMMANDS:\n" +
                "\"book\" to buy a ticket for the flight\n" +
                "\"check\" to check available places for the flight\n" +
                "\"return\" to return ticket wuth refund\n" +
                "\"view_hashID\" to view the booking confirmation info\n" +
                "\"view_username\" to view all booked tickets for a particular user");

        while (true) {
            System.out.print("Select: ");
            selection = scanner.nextLine();
            switch (selection) {
                case "book":
                    System.out.print("Select the data: ");
                    data = scanner.nextLine();

                    System.out.print("Select the flight_number: ");
                    flightNumber = scanner.nextLine();

                    System.out.print("Select the place for sitting: ");
                    place = scanner.nextLine();

                    System.out.print("Select the username: ");
                    user = scanner.nextLine();
                    Realisation.book(data, flightNumber, place, user);
                    break;

                case "check":
                    System.out.print("Select the data: ");
                    data = scanner.nextLine();

                    System.out.print("Select the flight_number: ");
                    flightNumber = scanner.nextLine();
                    Realisation.check(data, flightNumber);
                    break;

                case "return":
                    System.out.print("Select the hashID of your ticket: ");
                    hashID = scanner.nextInt();
                    Realisation.returnTicket(hashID);
                    break;

                case "view_username":
                    System.out.print("Select the username to check all user`s tickets: ");
                    user = scanner.nextLine();
                    Realisation.view(user);
                    break;

                case "view_hashID":
                    System.out.print("Select the hashID of your ticket to check the information: ");
                    hashID = scanner.nextInt();
                    Realisation.view(hashID);
                    break;
            }
        }
    }
}