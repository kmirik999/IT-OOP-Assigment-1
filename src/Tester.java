import java.io.IOException;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DataInputReader.readFlights();
        int pressFlight;

        System.out.print("Choose a Flight_Number: ");
        pressFlight = scanner.nextInt();

        DataInputReader.readDataFlights(DataInputReader.nameFlightNumbers.get(pressFlight - 1));

        Ticket.createTickets(DataInputReader.nameFlightNumbers.get(pressFlight - 1));



    }
}