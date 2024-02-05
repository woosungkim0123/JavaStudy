package strategy;

import strategy.sub.Item;
import strategy.sub.KakaoPayStrategy;
import strategy.sub.NaverPayStrategy;
import strategy.sub.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("컴퓨터", 1000000));
        cart.addItem(new Item("키보드", 20000));
        cart.addItem(new Item("마우스", 10000));

        // 카카오페이로 결제 선택 (전략 실행)
        cart.pay(new KakaoPayStrategy("1", "12/23", "123"));

        // 네이버페이로 결제 선택 (전략 실행)
        cart.pay(new NaverPayStrategy("2", "홍길동", "12/23"));
    }
}
