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
    public static ArrayList<Flight> nameFlightNumbers = new ArrayList<>();

    public static void readOneFile() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src//Flight2.txt"));
        boolean start = false;
        boolean end = false;
        String str;
        String name = "";
        String row = "";
        String data = "";
        int t = 0;

        while ((str = bf.readLine()) != null) {


            if (str.charAt(0) == '|' && start == false) {
                start = true;
                end = false;
                name = "";
                row = "";
                data = "";
                nameRows = new ArrayList<>();
                row_price = new HashMap<>();
                continue;
            } else if (str.charAt(0) == '|' && start == true) {
                start = false;
                end = true;

                for (; t < nameFlightNumbers.size(); t++) {
                    String[] tmp = nameFlightNumbers.get(t).getNameRow().split(" +");


                    for (String s : tmp) {
                        nameRows.add(s);
                    }
                    Ticket.createTickets(nameFlightNumbers.get(t).getNameFlight(), nameFlightNumbers.get(t).getData());
                }

                continue;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[') {
                    while (str.charAt(i + 1) != ']') {
                        name += str.charAt(i + 1);
                        i++;
                    }
                    break;
                }

                if (str.charAt(i) == '\'') {
                    while (str.charAt(i + 1) != '\'') {
                        row += str.charAt(i + 1);
                        i++;
                    }

                    break;
                }

                if (str.charAt(i) == '"') {
                    while (str.charAt(i + 1) != '"') {
                        data += str.charAt(i + 1);
                        i++;
                    }

                    nameFlightNumbers.add(new Flight(name, row, data));
                    System.out.println("!!!!!!!!!!!");
                    break;
                }


                if (str.charAt(i) == '<') {
                    String key = "";
                    String val = "";
                    // Считываем остальные строки файла(ряд - цена)
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i + 1) != '>') {
                            key += str.charAt(i + 1);
                            i++;
                        }
                    }
                    i += 2;
                    if (str.charAt(i) == '(') {
                        while (str.charAt(i + 1) != ')') {
                            val += str.charAt(i + 1);
                            i++;
                        }

                        row_price.put(key, Integer.parseInt(val));
                    }
                    break;
                }


            }


        }

    }

}