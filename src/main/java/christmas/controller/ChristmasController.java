package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.ChristmasService;
import christmas.util.Utils;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class ChristmasController {
    private final ChristmasService christmasService;

    public ChristmasController() {
        christmasService = new ChristmasService();
    }

    public void decemberPromotion() {
        int date = inputDate();
        Map<String, Integer> order = inputOrder(date);

        // 날짜입력 유효성 검증까지 완료 나중에 추가 예외케이스 보강
        // 주문서입력 유효성 검증까지 완료 나중에 추가 예외케이스 보강
        // 해야되는 것
        // 총 주문 금액이 10,000이상부터 이벤트가 적용
        // 음료만 주문시 주문할 수 없음
        // 메뉴는 한번에 20개까지만 주문할 수 있음
        // 할인 전 주문 금액이 120000이상이면 증정이벤트
        // 혜택이 없을 때 없음 출력
    }

    private int inputDate() {
        OutputView.outputViewWelcome();
        InputView.inputViewDate();

        while (true) {
            try {
                Date date = new Date(getInputDate());
                return date.getDate();
            } catch (IllegalArgumentException e) {

            }
        }
    }

    private Map<String, Integer> inputOrder(int date) {
        InputView.inputViewOrder();

        while (true) {
            try {
                Order order = new Order(getInputOrder());
                OutputView.outputViewPreviewEvent(date);
                OutputView.outputViewOrderMenu(order.getOrder());
                return order.getOrder();
            } catch (IllegalArgumentException e) {

            }
        }

    }

    private int getInputDate() {
        String userInput = InputView.input().trim();
        return Utils.stringToInteger(userInput);
    }

    private Map<String, Integer> getInputOrder() {
        return Utils.stringToMap(InputView.input().trim());
    }
}
