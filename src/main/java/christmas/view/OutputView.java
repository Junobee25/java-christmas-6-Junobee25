package christmas.view;

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

}
