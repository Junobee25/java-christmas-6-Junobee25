package christmas.controller;

import christmas.domain.Date;
import christmas.service.ChristmasService;
import christmas.util.Utils;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final ChristmasService christmasService;

    public ChristmasController() {
        christmasService = new ChristmasService();
        int date = inputDate();
    }

    public void decemberPromotion() {

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

    private int getInputDate() {
        String userInput = InputView.input().trim();
        return Utils.stringToInteger(userInput);
    }
}
