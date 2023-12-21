package mediator.sub;

public class ConcreteUser extends User {
    public ConcreteUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(name + "이(가) 메시지를 전송합니다: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(name + "이(가) 메시지를 받았습니다: " + msg);
    }
}
