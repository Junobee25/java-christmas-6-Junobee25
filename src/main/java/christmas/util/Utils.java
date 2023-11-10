package christmas.util;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static final String COMMAS = ",";
    private static final String DASH = "-";
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;


    public static Map<String, Integer> stringToMap(String userInput) {
        String[] selectFoods = stringToArray(userInput);
        Map<String, Integer> order = new HashMap<>();

        for (String item : selectFoods) {
            order.put(item.split(DASH)[MENU_INDEX], Integer.parseInt(item.split(DASH)[COUNT_INDEX]));
        }
        return order;
    }

    private static String[] stringToArray(String userInput) {
        String[] selectFoods = userInput.split(COMMAS);
        // validation
        return selectFoods;
    }
}
