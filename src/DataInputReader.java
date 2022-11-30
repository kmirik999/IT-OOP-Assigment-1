import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Класс для чтения информации с файлов
public class DataInputReader {
    //Сохраняет ряды и цены
    public static Map<String, Integer> mp = new HashMap();

    //Считывает рейсы с Flight.txt
    public static void readFlights() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src\\Flights.txt"));

        String str;
        while((str = bf.readLine()) != null){
            System.out.println(str);
        }
    }

    //Считывает с конкретного рейса .txt
    public static void readDataFlights(String nameFile) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader("src//" + nameFile + ".txt"));
        mp = new HashMap();
        String str;
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

    }

    //Проверка, смотрит сколько стоит конкертное место, относительно информации, которую считали с документа конкретного рейса
    public static int price(int sit){
        for(Map.Entry<String, Integer> t : mp.entrySet())
        {
            if(sit <= Integer.parseInt(t.getKey()))
            {
                return t.getValue();
            }
        }
        return -1;
    }
}
