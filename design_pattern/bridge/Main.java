package bridge;

import bridge.sub.CountDisplay;
import bridge.sub.Display;
import bridge.sub.HtmlDisplayImpl;
import bridge.sub.StringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(new StringDisplayImpl("테스트1 입니다."));
        display1.display();

        Display display2 = new Display(new StringDisplayImpl("테스트2 입니다."));
        display2.display();

        // 새로운 기능 추가
        CountDisplay countDisplay = new CountDisplay(new StringDisplayImpl("테스트3 입니다."));
        countDisplay.display();
        countDisplay.multiDisplay(5);

        // 새로운 구현 추가
        Display display3 = new Display(new HtmlDisplayImpl("테스트4 입니다."));
        display3.display();
    }
}
