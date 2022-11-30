import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static ArrayList<Ticket> tickets = new ArrayList<>();

//    public static void main(String[] args) throws IOException {
//        tickets.add(new Ticket("10.21.21", "FR12", "2A", "Mirik"));
//
//        //A
//        for(int i = 0; i < 10; i++){
//            tickets.add(new Ticket(null, "FR12", Integer.toString(i) + "A", null));
//        }
//        //B
//        for(int i = 0; i < 5; i++){
//            tickets.add(new Ticket(null, "FR12", Integer.toString(i) + "B", null));
//        }
//
////        for(Ticket t : tickets){
////            System.out.println(t.toString());
////        }
//
//        DataInputReader.readDataFlights();
//
//    }

    public static void main(String[] args) throws IOException {

        DataInputReader.readDataFlights("Data");



    }
}