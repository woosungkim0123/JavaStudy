package decorator.sub.decorator;

import decorator.sub.Cake;
import decorator.sub.CakeDecorator;

public class Sprinkles extends CakeDecorator {
    public Sprinkles(Cake cake) {
        super(cake);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("스프링클 추가");
    }
}
