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

    @DisplayName("메뉴 수량으로 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void validateOrderStringToInteger() {
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

    @DisplayName("날짜로 1 보다 작거나 31 보다 큰 숫자를 입력하면 예외가 발생한다.")
    @Test
    void validateRangeDate() {
        //given
        int case1 = -1;
        int case2 = 0;
        int case3 = 32;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateRangeDate(case1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateRangeDate(case2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateRangeDate(case3);
        });
    }

    @DisplayName("쉼표로 분리된 메뉴-개수 문자열이 -를 포함하지 않으면 예외가 발생한다.")
    @Test
    void validateInputString() {
        //given
        String case1 = "양송이수프,1,타파스-1";
        String case2 = "양송이수프,타파스";
        String case3 = "양송이수프-,타파스 ";
        String case4 = "양송이수프-,,-";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateInputString(case1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateInputString(case2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateInputString(case3);
        });

    }

    @DisplayName("주문 문자열이 - 기준으로 2개의 요소로 나눠지지 않으면 예외가 발생한다.")
    @Test
    void validateFoodArrayElement() {
        //given
        String[] case1 = {"양송이수프-2","양송이수프-"};
        String[] case2 = {"양송이수프-2","양송이수프"};
        String[] case3 = {"양송이수프-2","양송이수프---"};

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateFoodArrayElement(case1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateFoodArrayElement(case2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateFoodArrayElement(case3);
        });
    }

    @DisplayName("없는 메뉴를 주문하면 예외가 발생한다.")
    @Test
    void validateElementFood() {
        //given
        String[] case1 = {"라면-1"};

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateElementFood(case1);
        });
    }

    @Test
    void validateElementCount() {
    }

    @Test
    void validateDuplicationElementFood() {
    }
}