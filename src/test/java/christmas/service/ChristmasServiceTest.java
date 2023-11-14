package christmas.service;

import christmas.util.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasServiceTest {

    private ChristmasService christmasService;

    @BeforeEach
    void setUp() {
        christmasService = new ChristmasService();
    }

    @DisplayName("할인 된 가격 테스트")
    @Test
    void calculateTotalDiscount() {
        //given
        String userInput = "티본스테이크-2,바비큐립-1";
        Map<String, Integer> order = Utils.stringToMap(userInput);
        int date = 1;

        //when
        int result1 = christmasService.calculateTotalDiscount(date, order);

        //then
        assertEquals(result1, 7069);
    }

    @DisplayName("할인 전 총 구매 가격 테스트")
    @Test
    void calculateTotalPurchaseAmount() {
        //given
        String userInput = "티본스테이크-2,바비큐립-1";
        Map<String, Integer> order = Utils.stringToMap(userInput);

        //when
        int result1 = christmasService.calculateTotalPurchaseAmount(order);

        //then
        assertEquals(result1, 164000);
    }

    @DisplayName("혜택 받는 가격 테스트")
    @Test
    void calculateTotalBenefit() {
        //given
        String userInput = "티본스테이크-2,바비큐립-1";
        Map<String, Integer> order = Utils.stringToMap(userInput);
        int date = 1;

        //when
        int result1 = christmasService.calculateTotalBenefit(date, order);

        //then
        assertEquals(result1, 32069);
    }
}