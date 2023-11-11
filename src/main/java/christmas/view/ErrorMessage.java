package christmas.view;

public class ErrorMessage {
    private final static String INPUT_DATE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private final static String INPUT_MENU_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void inputDateError() {
        System.out.println(INPUT_DATE_ERROR);
    }

    public static void inputMenuError() {
        System.out.println(INPUT_MENU_ERROR);
    }
}
