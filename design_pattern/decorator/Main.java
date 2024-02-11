package decorator;

import decorator.sub.Client;
import decorator.sub.RealComponent;
import decorator.sub.decorator.*;

public class Main {
    public static void main(String[] args) {
        // 실체 객체 실행
        RealComponent realComponent = new RealComponent();
        Client client1 = new Client(realComponent);
        String result1 = client1.execute();
        printResult(result1);

        /**
         * 데코레이터 패턴은 기능을 추가할 때 기존 코드를 수정하지 않고 확장하는 방법을 제공합니다.
         */
        // Data에 장식을 추가한 객체 실행(MessageDecorator)
        MessageDecorator messageDecorator = new MessageDecorator(new RealComponent());
        Client client2 = new Client(messageDecorator);
        String result2 = client2.execute();
        printResult(result2);

        // MessageDecorator가 추가된 기존 장식에 실행 시간을 측정하는 장식을 추가한 객체 실행(TimeDecorator)
        TimeDecorator timeDecorator = new TimeDecorator(new MessageDecorator(new RealComponent()));
        Client client3 = new Client(timeDecorator);
        String result3 = client3.execute();
        printResult(result3);
    }

    private static void printResult(String result) {
        System.out.println();
        System.out.println("result: " + result);
        System.out.println();
    }
}
