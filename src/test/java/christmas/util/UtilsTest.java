package christmas.util;

import christmas.configuration.DiscountType;
import christmas.configuration.MenuType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    private static final String CHRISTMAS_EVENT = "크리스마스 디데이 할인";
    private static final String WEEKDAY_EVENT = "평일 할인";
    private static final String WEEKEND_EVENT = "주말 할인";
    private static final String SPECIAL_EVENT = "특별 할인";
    private static final String GIVE_WAY_EVENT = "증정 이벤트";

    @DisplayName("입력받은 날짜 숫자 타입으로 변환 테스트")
    @Test
    void stringDateToInteger() {
        //given
        String case1 = "1";
        String case2 = "10";

        //when
        int result1 = Utils.stringDateToInteger(case1);
        int result2 = Utils.stringDateToInteger(case2);

        //then
        assertEquals(1, result1);
        assertEquals(10, result2);
    }

    @DisplayName("입력 받은 주문 문자열 Map 자료구조 변환 테스트")
    @Test
    void stringToMap() {
        //given
        String userInput = "양송이수프-1,타파스-1";

        //when
        Map<String, Integer> myMap = Utils.stringToMap(userInput);

        //then
        assertEquals(1, myMap.get("양송이수프"));
        assertEquals(1, myMap.get("타파스"));
    }

    @DisplayName("금액을 원화 형태로 변환 테스트")
    @Test
    void formatPriceToWonType() {
        //given
        int case1 = 1234567;
        int case2 = 1000000000;

        //when
        String result1 = Utils.formatPriceToWonType(case1);
        String result2 = Utils.formatPriceToWonType(case2);

        //then
        assertEquals("1,234,567", result1);
        assertEquals("1,000,000,000", result2);
    }

    @DisplayName("구매한 메뉴 개수 테스트")
    @Test
    void countPurchaseAmount() {
        //given
        String userInput1 = "양송이수프-1,타파스-1";
        String userInput2 = "양송이수프-1,타파스-10";
        String userInput3 = "양송이수프-5,타파스-7";

        Map<String, Integer> case1 = Utils.stringToMap(userInput1);
        Map<String, Integer> case2 = Utils.stringToMap(userInput2);
        Map<String, Integer> case3 = Utils.stringToMap(userInput3);

        //when
        int result1 = Utils.countPurchaseAmount(case1);
        int result2 = Utils.countPurchaseAmount(case2);
        int result3 = Utils.countPurchaseAmount(case3);

        //then
        assertEquals(result1, 2);
        assertEquals(result2, 11);
        assertEquals(result3, 12);
    }

    @DisplayName("입력 날짜에 대해서 받는 혜텍들 반환 테스트")
    @Test
    void findDiscountType() {
        //given
        int case1 = 1;
        int case2 = 4;
        int case3 = 25;

        //when
        List<DiscountType> result1 = Utils.findDiscountType(case1);
        List<DiscountType> result2 = Utils.findDiscountType(case2);
        List<DiscountType> result3 = Utils.findDiscountType(case3);

        //then
        assertEquals(result1, Arrays.asList(DiscountType.WEEKEND, DiscountType.CHRISTMAS));
        assertEquals(result2, Arrays.asList(DiscountType.WEEKDAY, DiscountType.CHRISTMAS));
        assertEquals(result3, Arrays.asList(DiscountType.WEEKDAY, DiscountType.CHRISTMAS, DiscountType.SPECIAL));
    }

    @DisplayName("해당 음식의 메뉴 타입을 반환 테스트")
    @Test
    void findMenuType() {
        //given
        String userInput1 = "양송이수프-1,타파스-1";
        String userInput2 = "양송이수프-1,티본스테이크-10";
        String userInput3 = "제로콜라-5,레드와인-7";

        Map<String, Integer> case1 = Utils.stringToMap(userInput1);
        Map<String, Integer> case2 = Utils.stringToMap(userInput2);
        Map<String, Integer> case3 = Utils.stringToMap(userInput3);

        //when
        HashSet<MenuType> result1 = Utils.findMenuType(MenuType.APPETIZER, case1);
        HashSet<MenuType> result2 = Utils.findMenuType(MenuType.MAIN, case2);
        HashSet<MenuType> result3 = Utils.findMenuType(MenuType.BEVERAGE, case3);

        //then
        assertEquals(result1.contains(MenuType.APPETIZER), true);
        assertEquals(result2.contains(MenuType.MAIN), true);
        assertEquals(result3.contains(MenuType.BEVERAGE), true);
    }

    @DisplayName("해당되는 이벤트에 받는 혜택 금액 반환 테스트")
    @Test
    void makeDiscountMap() {
        //given
        String userInput = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> order = Utils.stringToMap(userInput);
        int date = 3;
        int price = 142000;

        //when
        Map<String, Integer> result = Utils.makeDiscountMap(date, order, price);

        //then
        assertEquals(result.get(CHRISTMAS_EVENT), 1200);
        assertEquals(result.get(WEEKDAY_EVENT), 4046);
        assertEquals(result.get(SPECIAL_EVENT), 1000);
        assertEquals(result.get(GIVE_WAY_EVENT), 25000);
    }

    @DisplayName("받을 수 있는 뱃지 테스트")
    @Test
    void searchBenefitBadge() {
        //given
        int case1 = 20000;
        int case2 = 15000;
        int case3 = 10000;
        int case4 = 5000;
        int case5 = 2500;
        int case6 = 0;

        //when
        String result1 = Utils.searchBenefitBadge(case1);
        String result2 = Utils.searchBenefitBadge(case2);
        String result3 = Utils.searchBenefitBadge(case3);
        String result4 = Utils.searchBenefitBadge(case4);
        String result5 = Utils.searchBenefitBadge(case5);
        String result6 = Utils.searchBenefitBadge(case6);

        //then
        assertEquals(result1, "산타");
        assertEquals(result2, "트리");
        assertEquals(result3, "트리");
        assertEquals(result4, "별");
        assertEquals(result5, "없음");
        assertEquals(result6, "없음");
    }
}