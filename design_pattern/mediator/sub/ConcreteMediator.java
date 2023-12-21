package mediator.sub;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private final List<User> users;

    public ConcreteMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        users.stream()
            .filter(u -> u != user)
            .forEach(u -> u.receive(msg));
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
