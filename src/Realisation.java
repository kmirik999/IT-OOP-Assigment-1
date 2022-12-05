public class Realisation {
    public static void check(String data, String flightNumber){
        for(Ticket tk : Ticket.tickets){
            if(tk.getData().equals(data) && tk.getFlightNumber().equals(flightNumber) && tk.getUsername() == null)
                System.out.println(tk.getPlaceInPlane() + " " + tk.getPrice());
        }

    }

    public static void book(String data, String flightNumber, String placeInPlane, String username){
        for(Ticket ticket : Ticket.tickets)
        {
            // проверить работу стринга с null
            if(ticket.getData().equals(data) && ticket.getFlightNumber().equals(flightNumber) && ticket.getPlaceInPlane().equals(placeInPlane) && ticket.getUsername() == null)
            {
                ticket.setUsername(username);
                System.out.println("Confirmed with ID" + ticket.getHashID());
                return;
            } else if(ticket.getData().equals(data) && ticket.getFlightNumber().equals(flightNumber) && ticket.getPlaceInPlane().equals(placeInPlane) && ticket.getUsername() != null){
                System.out.println( "The ticket was booked");
                return;
            }
        }
        System.out.println("Sorry! That ticket doesn`t exist. Book another please.");
    }

    // Возврощает билет обратно в базу, онулируют покупку, возврощает деньги клиенту. username = null
    // !!!ЕСТЬ ВОЗМОЖНОСТЬ ОПТИМИЗАЦИИ!!
    public static void refund(int hashID){
        boolean tExist = false;
        for(Ticket t : Ticket.tickets){
            if(tExist == false && t.getHashID() == hashID) tExist = true;
            if(t.getHashID() == hashID && t.getUsername() != null){
                System.out.println("Confirmed " + t.getPrice() + " refund for " + t.getUsername());
                t.setUsername(null);
                return;
            }
        }
        if(tExist == false){
            System.out.println("Ticket ID: " + hashID + " doesn`t exist!");
        } else {
            System.out.println("Ticket ID: " + hashID + " wasn`t been booked!");
        }

    }

    public static void view(int hashID){
        boolean tExist = false;
        for(Ticket t : Ticket.tickets){
            if(tExist == false && t.getHashID() == hashID) tExist = true;
            if(t.getHashID() == hashID && t.getUsername() != null){
                System.out.println("Flight " + t.getFlightNumber() + ", " + t.getData() + ", seat " + t.getPlaceInPlane() + ", price " + t.getPrice() + ", " + t.getUsername());
                return;
            }
        }

        if(tExist == false){
            System.out.println("Ticket ID: " + hashID + " doesn`t exist!");
        } else {
            System.out.println("Ticket ID: " + hashID + " wasn`t been booked!");
        }
    }

    public static void view(String username){
        boolean user_booked = false;
        for(Ticket t : Ticket.tickets){
            if(t.getUsername() != null && user_booked == false && t.getUsername().equals(username)) user_booked = true;
            if(t.getUsername() != null && t.getUsername().equals(username)){
                System.out.println("Flight " + t.getFlightNumber() + ", " + t.getData() + ", seat " + t.getPlaceInPlane() + ", price " + t.getPrice() + ", " + t.getUsername());
            }
        }

        if(user_booked == false){
            System.out.println(username + " didn`t book any tickets!");
        }
    }
}