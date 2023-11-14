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

    @DisplayName("쉼표 입력에 대한 예외 처리")
    @Test
    void validateEmptyArray() {
        //given
        String userInput = ",";
        String[] splitUserInput = userInput.split(",");

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateEmptyArray(splitUserInput);
        });
    }


    @Test
    void validateDateStringToInteger() {
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