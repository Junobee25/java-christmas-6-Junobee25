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
        Map<String, Integer> order = inputOrder();
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

    public Map<String, Integer> inputOrder() {
        InputView.inputViewOrder();

        while (true) {
            try {
                Order order = new Order(getInputOrder());
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
