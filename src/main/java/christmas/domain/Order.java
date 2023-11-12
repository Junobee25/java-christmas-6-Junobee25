package christmas.domain;

import christmas.configuration.MenuType;
import christmas.util.Utils;
import christmas.view.ErrorMessage;

import java.util.*;

public class Order {
    private final Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        validateOnlyBeverage(order);
        this.order = order;
    }

    private void validateOnlyBeverage(Map<String, Integer> order) {
        HashSet<MenuType> menus = new HashSet<>();

        for (MenuType menu : MenuType.values()) {
            Utils.findMenuType(menu, order);
        }

        if (menus.contains(MenuType.BEVERAGE) && menus.size() == 1) {
            ErrorMessage.inputMenuError();
            throw new IllegalArgumentException();
        }
    }

    public Map<String, Integer> getOrder() {
        return order;
    }
}
