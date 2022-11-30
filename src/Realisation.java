public class Realisation {
//    public static Ticket check(String data, String flightNumber){
//        for(Ticket tk : Tester.tickets){
//            if(tk.data.equals(data) && tk.flightNumber.equals(flightNumber)) return tk.
//        }
//
//    }

    public static String book(String data, String flightNumber, String placeInPlane, String username){
        for(Ticket ticket : Ticket.tickets)
        {
            // проверить работу стринга с null
            if(ticket.data.equals(data) && ticket.flightNumber.equals(flightNumber) && ticket.placeInPlane.equals(placeInPlane) && ticket.username.equals(null))
            {
                ticket.username = username;
                return "Confirmed with ID" + ticket.hashID;
            } else if(ticket.data.equals(data) && ticket.flightNumber.equals(flightNumber) && ticket.placeInPlane.equals(placeInPlane) && !ticket.username.equals(null)){
                return "The ticket was booked";
            }
        }
        return "Sorry! That ticket doesn`t exist. Book another please.";
    }
}