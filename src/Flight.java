public class Flight {

    private String nameFlight;
    private String nameRow;
    private String data;


    public Flight(String nameFlight, String nameRow, String data){
        this.nameFlight = nameFlight;
        this.nameRow = nameRow;
        this.data = data;
    }

    public String getNameFlight() {
        return nameFlight;
    }

    public void setNameFlight(String nameFlight) {
        this.nameFlight = nameFlight;
    }

    public String getNameRow() {
        return nameRow;
    }

    public void setNameRow(String nameRow) {
        this.nameRow = nameRow;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}