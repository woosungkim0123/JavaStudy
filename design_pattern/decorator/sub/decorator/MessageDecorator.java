package decorator.sub.decorator;

import decorator.sub.Component;
import decorator.sub.Decorator;

public class MessageDecorator extends Decorator {

    public MessageDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        System.out.println("==Message Decorator 실행==");
        String result = super.component.operation();
        String decoResult = "****" + result + "****";

        System.out.println("==Message Decorator 종료==");
        return decoResult;
    }
}
