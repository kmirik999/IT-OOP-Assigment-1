public class Ticket {
    public String data;
    public String flightNumber;
    public String placeInPlane;
    public String username;
    public int hashID;

    public int countTicket = 0;

    public Ticket(){}

    public Ticket(String data, String flightNumber, String placeInPlane, String username){
        this.data = data;
        this.flightNumber = flightNumber;
        this.placeInPlane = placeInPlane;
        this.username = username;
        this.hashID = hashCodeCreate();
    }

    public int hashCodeCreate(){
        return countTicket++;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();

        st.append(data).append(" " + flightNumber).append(" " + placeInPlane).append(" " + username);
        return st.toString();
    }
}
