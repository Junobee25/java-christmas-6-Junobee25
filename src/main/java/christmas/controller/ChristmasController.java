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
        int totalPrice = christmasService.calculateTotalPurchaseAmount(order);

        showResult(date, order, totalPrice);
    }

    private void showResult(int date, Map<String, Integer> order, int totalPrice) {
        if (totalPrice >= 10000) {
            showEventResult(date, order, totalPrice);
        }
        if (totalPrice < 10000) {
            showNotEventResult(order);
        }
    }

    private void showEventResult(int date, Map<String, Integer> order, int totalPrice) {
        int totalBenefits = christmasService.calculateTotalBenefit(date, order);
        int totalDiscount = christmasService.calculateTotalDiscount(date, order);

        OutputView.outputViewOrderAmount(totalPrice);
        OutputView.outputViewGiveWayMenu(totalPrice);
        OutputView.outputViewBenefit();
        OutputView.outputViewBenefitDetail(Utils.makeDiscountMap(date, order, totalPrice));
        OutputView.outputViewTotalDiscount(totalBenefits);
        OutputView.outputViewEstimatedPayment(totalPrice - totalDiscount);
        OutputView.outputViewEventBadge(getBadge(totalBenefits));
    }

    private void showNotEventResult(Map<String, Integer> order) {
        int totalPrice = christmasService.calculateTotalPurchaseAmount(order);

        OutputView.outputViewOrderAmount(totalPrice);
        OutputView.outputViewGiveWayMenu(totalPrice);
        OutputView.outputViewNotBenefit();
        OutputView.outputViewNotDiscountBenefit();
        OutputView.outputViewEstimatedPayment(totalPrice);
        OutputView.outputViewNotBadge();
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
        return Utils.stringDateToInteger(userInput);
    }

    private Map<String, Integer> getInputOrder() {
        return Utils.stringToMap(InputView.input().trim());
    }

    private String getBadge(int totalBenefit) {
        return Utils.searchBenefitBadge(totalBenefit);
    }
}
