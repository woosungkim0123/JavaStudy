package decorator.sub.decorator;

import decorator.sub.Cake;
import decorator.sub.CakeDecorator;

public class chocolateChip extends CakeDecorator {
    public chocolateChip(Cake cake) {
        super(cake);
    }
    
    @Override
    public void decorate() {
        super.decorate();
        System.out.println("초콜릿 칩 추가");
    }
}
