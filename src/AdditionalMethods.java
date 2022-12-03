import java.util.Map;

public class AdditionalMethods {

    public static int countAmountPlaces() {
        int max = 0;

        if (!DataInputReader.row_price.isEmpty())
            for (Map.Entry<String, Integer> t : DataInputReader.row_price.entrySet()) {
                String[] tmpArr = t.getKey().split("-");
                if (max < Integer.parseInt(tmpArr[1])) {
                    max = Integer.parseInt(tmpArr[1]);
                }
            }

        return max;
    }

}