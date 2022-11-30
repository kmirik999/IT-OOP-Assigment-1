import java.util.ArrayList;
import java.util.Map;

public class Ticket {
    public String data;
    public String flightNumber;
    public String placeInPlane;
    public String username;
    public double price;
    public int hashID;

    public int countTicket = 0;

    public Ticket(){}
    public static ArrayList<Ticket> tickets = new ArrayList<>();

    public Ticket(String data, String flightNumber, String placeInPlane, String username, double price){
        this.data = data;
        this.flightNumber = flightNumber;
        this.placeInPlane = placeInPlane;
        this.username = username;
        this.price = price;
        this.hashID = hashCodeCreate();
    }

    public int hashCodeCreate(){
        return countTicket++;
    }

    public static void createTickets(String flightNumber){
        int amountPlaces_Row = AdditionalMethods.countAmountPlaces();
        for(String nameR : DataInputReader.nameRows){
            for(int i = 1; i <= amountPlaces_Row; i++){
                tickets.add(new Ticket("20.01.22", flightNumber, Integer.toString(i) + nameR, null, price(i)));
            }
        }
        System.out.println();
    }

    //Проверка, смотрит сколько стоит конкертное место, относительно информации, которую считали с документа конкретного рейса
    public static double price(int sit){
        for(Map.Entry<String, Integer> t : DataInputReader.mp.entrySet())
        {
            if(sit <= Integer.parseInt(t.getKey()))
            {
                return t.getValue();
            }
        }
        return -1;
    }



    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();

        st.append(data).append(" " + flightNumber).append(" " + placeInPlane).append(" " + username);
        return st.toString();
    }
}