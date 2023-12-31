package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String EXPECTED_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final static String SELECT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static String input() {
        return Console.readLine();
    }

    public static void inputViewDate() {
        System.out.println(EXPECTED_DATE);
    }

    public static void inputViewOrder() {
        System.out.println(SELECT_MENU);
    }
}
