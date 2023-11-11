package christmas.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void stringToMap() {
        //given
        String userInput = "양송이수프-1,타파스-1";

        //when
        Map<String, Integer> myMap =  Utils.stringToMap(userInput);

        //then
        assertEquals(1, myMap.get("양송이수프"));
        assertEquals(1, myMap.get("타파스"));

    }
}