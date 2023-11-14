package christmas.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @DisplayName("날짜 입력하지 않으면 예외가 발생한다.")
    @Test
    void validateDateEmptyInput() {
        //given
        String userInput = "";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateDateEmptyInput(userInput);
        });

    }

    @DisplayName("주문 입력하지 않으면 예외가 발생한다.")
    @Test
    void validateOrderEmptyInput() {
        //given
        String userInput = "";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateOrderEmptyInput(userInput);
        });
    }

    @DisplayName("쉼표 하나 입력시 예외가 발생한다.")
    @Test
    void validateEmptyArray() {
        //given
        String userInput = ",";
        String[] splitUserInput = userInput.split(",");

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateEmptyArray(splitUserInput);
        });
    }

    @DisplayName("날짜로 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void validateDateStringToInteger() {
        //given
        String case1 = " ";
        String case2 = "a";
        String case3 = "a1";
        String case4 = "1 2";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateDateStringToInteger(case1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateDateStringToInteger(case2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateDateStringToInteger(case3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateDateStringToInteger(case4);
        });

    }

    @Test
    void validateOrderStringToInteger() {
    }

    @Test
    void validateRangeDate() {
    }

    @Test
    void validateInputString() {
    }

    @Test
    void validateFoodArrayElement() {
    }

    @Test
    void validateElementFood() {
    }

    @Test
    void validateElementCount() {
    }

    @Test
    void validateDuplicationElementFood() {
    }
}