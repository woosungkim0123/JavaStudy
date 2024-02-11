package decorator.sub.decorator;

import decorator.sub.Component;
import decorator.sub.Decorator;

public class TimeDecorator extends Decorator {

    public TimeDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        System.out.println("Time Decorator 실행");

        long start = System.currentTimeMillis();

        String result = super.component.operation();

        long end = System.currentTimeMillis();

        System.out.println("실행시간 : " + (end - start));
        System.out.println("==Time Decorator 종료==");
        return result;
    }
}
