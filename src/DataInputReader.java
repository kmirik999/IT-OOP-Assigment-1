import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Класс для чтения информации с файлов
public class DataInputReader {
    //Сохраняет ряды и цены
    public static Map<String, Integer> row_price;
    public static ArrayList<String> nameRows;
    public static ArrayList<String> nameFlightNumbers = new ArrayList<>();

    //Считывает рейсы с Flight.txt
    public static void readFlights() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Flights.txt"));

        String str;
        while((str = bf.readLine()) != null){
            nameFlightNumbers.add(str);
        }

        for(String nameFile : nameFlightNumbers){
            nameRows = new ArrayList<>();
            row_price = new HashMap();
            bf = new BufferedReader(new FileReader(nameFile + ".txt"));

            // Считываем первый ряд(Имена рядов: А B C...)
            if((str = bf.readLine()) != null){
                String[] tmp = str.split(" +");
                for(String s : tmp){
                    nameRows.add(s);
                }
            }

            // Считываем остальные строки файла(ряд - цена)
            while((str = bf.readLine()) != null){
                String key = "";
                String val = "";
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '<'){
                        while(str.charAt(i + 1) != '>') {
                            key += str.charAt(i + 1);
                            i++;
                        }

                    }

                    if(str.charAt(i) == '('){
                        while(str.charAt(i + 1) != ')') {
                            val += str.charAt(i + 1);
                            i++;
                        }
                    }
                }

                row_price.put(key, Integer.parseInt(val));
            }

            Ticket.createTickets(nameFile);
        }
    }


}