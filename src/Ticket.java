import java.util.ArrayList;
import java.util.Map;

public class Ticket {
    private String data;
    private String flightNumber;
    private String placeInPlane;
    private String username;
    private double price;
    private int hashID;

    public static ArrayList<Ticket> tickets = new ArrayList<>();

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPlaceInPlane() {
        return placeInPlane;
    }

    public void setPlaceInPlane(String placeInPlane) {
        this.placeInPlane = placeInPlane;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHashID() {
        return hashID;
    }

    public void setHashID(int hashID) {
        this.hashID = hashID;
    }

    public static int countTicket = 0;

    public Ticket(String data, String flightNumber, String placeInPlane, String username, double price){
        this.data = data;
        this.flightNumber = flightNumber;
        this.placeInPlane = placeInPlane;
        this.username = username;
        this.price = price;
        this.hashID = hashCodeCreate();
    }

    public static int hashCodeCreate(){
        return countTicket++;
    }

    // Создает и добовляет в массив все билеты всех рейсов
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
        for(Map.Entry<String, Integer> t : DataInputReader.row_price.entrySet())
        {
            //  Сплитим, чтобы выделить отдельно числа и взять большое из них
            String[] splitRangeRows = t.getKey().split("-");

            if(Integer.parseInt(splitRangeRows[0]) <= sit && sit <= Integer.parseInt(splitRangeRows[1]))
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