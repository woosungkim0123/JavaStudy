package prototype;

import prototype.framework.ManagerA;
import prototype.framework.ManagerB;
import prototype.sub.MessageBoxA;
import prototype.sub.MessageBoxB;
import prototype.sub.UnderlinePenA;
import prototype.sub.UnderlinePenB;

public class Main {
    public static void main(String[] args) {
        // sub1 - clone 사용 (shallow copy)
        // 준비
        ManagerA manager = new ManagerA();
        UnderlinePenA underlinePen = new UnderlinePenA('~');
        MessageBoxA messageBox = new MessageBoxA('*');
        MessageBoxA messageBox2 = new MessageBoxA('/');

        // 등록
        manager.register("strong message", underlinePen);
        manager.register("warning box", messageBox);
        manager.register("slash box", messageBox2);

        // 생성 및 사용
        manager.create("strong message").use("Hello, world.");
        manager.create("warning box").use("Hello, world.");
        manager.create("slash box").use("Hello, world.");

        System.out.println();

        // sub2 - 복사 생성자 만들어서 사용 (deep copy)
        // 준비
        ManagerB managerB = new ManagerB();
        UnderlinePenB underlinePenB = new UnderlinePenB('~');
        MessageBoxB messageBox3 = new MessageBoxB('*');
        MessageBoxB messageBox4 = new MessageBoxB('/');

        // 등록
        managerB.register("strong message", underlinePenB);
        managerB.register("warning box", messageBox3);
        managerB.register("slash box", messageBox4);

        // 생성 및 사용
        managerB.create("strong message").use("Deep copy");
        managerB.create("warning box").use("Deep copy");
        managerB.create("slash box").use("Deep copy");
    }
}
