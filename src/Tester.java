import java.io.IOException;
import java.time.temporal.Temporal;

public class Tester {

    public static void main(String[] args) throws IOException {
        DataInputReader.readOneFile();

//        for(Ticket t : Ticket.tickets){
//            System.out.println(t.toString());
//        }
        System.out.println("1");
        Realisation.book("10.09.23", "HJ114", "2B", "Alex_Akhmadov");
        System.out.println("2");
        Realisation.book("03.05.23", "FQ12", "12C", "Alex_Akhmadov");
        System.out.println("===========================");

//        for(Ticket t : Ticket.tickets){
//            System.out.println(t.toString());
//        }

        Realisation.view("Alex_Akhmadov");

//        Realisation.refund(61);
        System.out.println("===========================");
        Realisation.view("Alex_Akhmadov");

        System.out.println("===========================\n");
        Realisation.check("10.09.23", "HJ114");
//        Realisation.view(188);

    }
}