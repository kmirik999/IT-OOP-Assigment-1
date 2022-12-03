import java.io.IOException;

public class Tester {

    public static void main(String[] args) throws IOException {
        DataInputReader.readFlights();

        for(Ticket t : Ticket.tickets){
            System.out.println();
        }
    }
}