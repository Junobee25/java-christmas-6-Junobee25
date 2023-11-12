package christmas.view;

import org.mockito.internal.matchers.Or;

public class OutputView {
    private final static String WELCOME_RESTAURANT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String PREVIEW_EVENT = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final static String ORDER_MENU = "<주문 메뉴>";
    private final static String DETAIL_ORDER = "%s %d개";
    private final static String ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private final static String DETAIL_ORDER_AMOUNT_BEFORE_DISCOUNT = "%s원";
    private final static String GIVEAWAY_MENU = "%s %d개";
    private final static String BENEFIT = "<혜택 내역>";
    private final static String BENEFIT_DETAIL = "%s: -%d원";
    private final static String TOTAL_BENEFIT_DISCOUNT = "<총혜택 금액>";
    private final static String TOTAL_BENEFIT_DISCOUNT_DETAIL = "-%s원";
    private final static String ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private final static String ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT_DETAIL = "%s원";
    private final static String DECEMBER_EVENT_BADGE = "<12월 이벤트 배지>";
    private final static String DECEMBER_EVENT_BADGE_DETAIL = "%s";

    public static void outputViewWelcome() {
        System.out.println(WELCOME_RESTAURANT);
    }

    public static void outputViewPreviewEvent() {
        System.out.println(PREVIEW_EVENT);
    }

    public static void outputViewOrderMenu() {
        System.out.println(ORDER_MENU);
    }

    public static void outputViewDetailOrder(String menu, int count) {
        System.out.printf(DETAIL_ORDER, menu, count);
    }

    public static void outputViewOrderAmount() {
        System.out.println(ORDER_AMOUNT_BEFORE_DISCOUNT);
    }

    public static void outputViewDetailOrderAmount(int price) {
        System.out.printf(DETAIL_ORDER_AMOUNT_BEFORE_DISCOUNT, price);
    }

    public static void outputViewGiveWayMenu(String goods, int count) {
        System.out.printf(GIVEAWAY_MENU, goods, count);
    }

    public static void outputViewBenefit() {
        System.out.println(BENEFIT);
    }

    public static void outputViewDetailBenefit(String event, int discount) {
        System.out.printf(BENEFIT_DETAIL, event, discount);
    }

    public static void outputViewTotalDiscount() {
        System.out.println(TOTAL_BENEFIT_DISCOUNT);
    }

    public static void outputViewTotalDetailDiscount(int discount) {
        System.out.printf(TOTAL_BENEFIT_DISCOUNT_DETAIL, discount);
    }

    public static void outputViewEstimatedPayment() {
        System.out.println(ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT);
    }

    public static void outputViewEstimatedDetailPayment(int totalPrice) {
        System.out.printf(ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT_DETAIL, totalPrice);
    }

    public static void outputViewEventBadge() {
        System.out.println(DECEMBER_EVENT_BADGE);
    }

    public static void outputViewDetailEventBadge(String badge) {
        System.out.printf(DECEMBER_EVENT_BADGE_DETAIL, badge);
    }

}
