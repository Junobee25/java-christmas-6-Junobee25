package christmas.view;

import christmas.configuration.GiveWayType;
import christmas.util.Utils;
import org.mockito.internal.matchers.Or;

import java.util.Map;

public class OutputView {
    private final static String WELCOME_RESTAURANT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String PREVIEW_EVENT = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n";
    private final static String ORDER_MENU = "<주문 메뉴>";
    private final static String DETAIL_ORDER = "%s %d개\n";
    private final static String ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private final static String DETAIL_ORDER_AMOUNT_BEFORE_DISCOUNT = "%s원\n\n";
    private final static String GIVEAWAY_MENU = "<증정 메뉴>";
    private final static String GIVEAWAY_MENU_DETAIL = "%s %d개\n\n";
    private final static String BENEFIT = "<혜택 내역>";
    private final static String BENEFIT_DETAIL = "%s: -%s원\n";
    private final static String TOTAL_BENEFIT_DISCOUNT = "<총혜택 금액>";
    private final static String TOTAL_BENEFIT_DISCOUNT_DETAIL = "-%s원\n\n";
    private final static String ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private final static String ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT_DETAIL = "%s원\n\n";
    private final static String DECEMBER_EVENT_BADGE = "<12월 이벤트 배지>";
    private final static String DECEMBER_EVENT_BADGE_DETAIL = "%s\n";
    private final static String NONE = "없음";

    public static void outputViewWelcome() {
        System.out.println(WELCOME_RESTAURANT);
    }

    public static void outputViewPreviewEvent(int date) {
        System.out.printf(PREVIEW_EVENT, date);
    }

    public static void outputViewOrderMenu(Map<String, Integer> order) {
        System.out.println(ORDER_MENU);

        for (Map.Entry<String, Integer> menu : order.entrySet()) {
            System.out.printf(DETAIL_ORDER, menu.getKey(), menu.getValue());
        }
        System.out.println();
    }

    public static void outputViewOrderAmount(int price) {
        System.out.println(ORDER_AMOUNT_BEFORE_DISCOUNT);
        System.out.printf(DETAIL_ORDER_AMOUNT_BEFORE_DISCOUNT, Utils.formatPriceToWonType(price));
    }

    public static void outputViewGiveWayMenu(int totalPrice) {
        System.out.println(GIVEAWAY_MENU);

        if (totalPrice >= 120000) {
            System.out.printf(GIVEAWAY_MENU_DETAIL, GiveWayType.GIVE_WAY.getGiveWay(), GiveWayType.GIVE_WAY.getCount());
        }
        if (totalPrice < 120000) {
            System.out.println(NONE);
            System.out.println();
        }

    }

    public static void outputViewBenefit() {
        System.out.println(BENEFIT);
    }

    public static void outputViewBenefitDetail(Map<String, Integer> eventDiscount) {
        for (Map.Entry<String, Integer> event : eventDiscount.entrySet()) {
            if (event.getValue() != 0) {
                System.out.printf(BENEFIT_DETAIL, event.getKey(), Utils.formatPriceToWonType(event.getValue()));
            }
        }

        if (eventDiscount.values().stream().allMatch(value -> value == 0)) {
            System.out.println(NONE);
        }
    }

    public static void outputViewTotalDiscount(int discount) {
        System.out.println(TOTAL_BENEFIT_DISCOUNT);
        System.out.printf(TOTAL_BENEFIT_DISCOUNT_DETAIL, Utils.formatPriceToWonType(discount));
    }

    public static void outputViewEstimatedPayment(int totalPrice) {
        System.out.println(ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT);
        System.out.printf(ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT_DETAIL, Utils.formatPriceToWonType(totalPrice));
    }

    public static void outputViewEventBadge(String badge) {
        System.out.println(DECEMBER_EVENT_BADGE);
        System.out.printf(DECEMBER_EVENT_BADGE_DETAIL, badge);
    }

    public static void outputViewNotBenefit() {
        System.out.println(BENEFIT);
        System.out.println(NONE);
        System.out.println();
    }

    public static void outputViewNotDiscountBenefit() {
        System.out.println(TOTAL_BENEFIT_DISCOUNT);
        System.out.println(NONE);
        System.out.println();
    }

    public static void outputViewNotBadge() {
        System.out.println(DECEMBER_EVENT_BADGE);
        System.out.print(NONE);
    }
}
