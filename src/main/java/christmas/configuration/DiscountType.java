package christmas.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum DiscountType {
    WEEKDAY(Arrays.asList(4, 5, 6, 7, 11, 12, 13, 14, 18, 19, 20, 21, 25, 26, 27, 28), dessertPrice -> dessertPrice - 2023),
    WEEKEND(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), mainPrice -> mainPrice - 2023),
    CHRISTMAS(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 29, 20, 21, 22, 23, 24, 25), date -> 100 * (date - 1));

    private final List<Integer> dates;
    private final Function<Integer, Integer> expression;

    DiscountType(List<Integer> dates, Function<Integer, Integer> expression) {
        this.dates = dates;
        this.expression = expression;
    }

}
