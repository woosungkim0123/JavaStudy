package prototype;

import prototype.framework.Manager;
import prototype.sub.MessageBox;
import prototype.sub.UnderlinePen;

public class Main {
    public static void main(String[] args) {
        // 준비
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox messageBox = new MessageBox('*');
        MessageBox messageBox2 = new MessageBox('/');

        // 등록
        manager.register("strong message", underlinePen);
        manager.register("warning box", messageBox);
        manager.register("slash box", messageBox2);

        // 생성 및 사용
        manager.create("strong message").use("Hello, world.");

        manager.create("warning box").use("Hello, world.");
        manager.create("slash box").use("Hello, world.");
    }
}
