package decorator.sub.decorator;

import decorator.sub.Cake;
import decorator.sub.CakeDecorator;

public class chocolateCream extends CakeDecorator {
    public chocolateCream(Cake cake) {
        super(cake);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("초콜릿 크림 추가");
    }
}
