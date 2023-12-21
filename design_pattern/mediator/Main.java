package mediator;

import mediator.sub.ConcreteMediator;
import mediator.sub.ConcreteUser;
import mediator.sub.Mediator;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteUser user1 = new ConcreteUser(mediator, "홍길동");
        ConcreteUser user2 = new ConcreteUser(mediator, "이순신");
        ConcreteUser user3 = new ConcreteUser(mediator, "강감찬");

        // 중재자에게 사용자를 추가합니다.
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.send("안녕하세요.");
        user2.send("반갑습니다.");
        user3.send("만나서 반가워요.");

    }
}
