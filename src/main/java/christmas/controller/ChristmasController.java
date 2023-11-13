package christmas.controller;

import christmas.configuration.BadgeType;
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
        showResult(date, order);

    }

    private void showResult(int date, Map<String, Integer> order) {
        int totalPrice = christmasService.calculateTotalPurchaseAmount(order);
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

    private String getBadge(int totalBenefit) {
        if (totalBenefit >= BadgeType.SANTA.getBenefit()) {
            return BadgeType.SANTA.getBadge();
        }
        if (totalBenefit >= BadgeType.TREE.getBenefit()) {
            return BadgeType.TREE.getBadge();
        }
        if (totalBenefit >= BadgeType.STAR.getBenefit()) {
            return BadgeType.STAR.getBadge();
        }
        return BadgeType.NONE_BADGE.getBadge();
    }
}
