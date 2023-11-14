package christmas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

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


}