import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Класс для чтения информации с файлов
public class DataInputReader {
    //Сохраняет ряды и цены
    public static Map<String, Integer> mp = new HashMap();
    public static ArrayList<String> nameRows = new ArrayList<>();
    public static ArrayList<String> nameFlightNumbers = new ArrayList<>();

    //Считывает рейсы с Flight.txt
    public static void readFlights() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Flights.txt"));

        String str;
        int i = 1;
        while((str = bf.readLine()) != null){
            System.out.println(i++ + ". " + str);
            nameFlightNumbers.add(str);
        }
    }

    //Считывает с конкретного рейса .txt
    public static void readDataFlights(String nameFile) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader(nameFile + ".txt"));
        mp = new HashMap();
        String str;

        if((str = bf.readLine()) != null){
            String[] tmp = str.split(" +");
            for(String s : tmp){
                nameRows.add(s);
            }
        }

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

            mp.put(key, Integer.parseInt(val));
        }

        System.out.println();
    }


}