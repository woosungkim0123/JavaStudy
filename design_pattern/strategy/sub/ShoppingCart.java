package strategy.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * 컨텍스트 - 전략을 등록하고 실행
 */
public class ShoppingCart {
    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void pay(PaymentStrategy paymentStrategy) {
        int total = items.stream()
                .mapToInt(Item::getPrice)
                .sum();

        paymentStrategy.pay(total);
    }
}
