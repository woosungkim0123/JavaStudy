package mediator.sub;

public interface Mediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}
