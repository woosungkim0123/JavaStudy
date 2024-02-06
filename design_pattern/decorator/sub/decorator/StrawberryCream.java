package decorator.sub.decorator;

import decorator.sub.Cake;
import decorator.sub.CakeDecorator;

public class StrawberryCream extends CakeDecorator {
    public StrawberryCream(Cake cake) {
        super(cake);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("딸기 크림 추가");
    }
}
