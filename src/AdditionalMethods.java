import java.util.Map;

public class AdditionalMethods {

    public static int countAmountPlaces() {
        int count = 0;
        int i = 1;

        if (!DataInputReader.mp.isEmpty())
            for (Map.Entry<String, Integer> t : DataInputReader.mp.entrySet()) {
                if (i == DataInputReader.mp.size()) {
                    count += Integer.parseInt(t.getKey());
                    return count;
                }
                i++;
            }

        return -1;
    }

}