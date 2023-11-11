package christmas.service;

import christmas.util.Utils;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasServiceTest {

    @Test
    void calculateTotalDiscount() {
        //given
        ChristmasService christmasService = new ChristmasService();
        String userInput = "티본스테이크-2,바비큐립-1";
        Map<String, Integer> order = Utils.stringToMap(userInput);
        int date = 1;

        //when
        int result1 = christmasService.calculateTotalDiscount(date, order);

        //then
        org.assertj.core.api.Assertions.assertThat(result1).isEqualTo(5046);

    }
}