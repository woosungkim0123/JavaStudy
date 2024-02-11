package decorator.sub;

public class Client {

    private Component component;

    public Client(Component component) {
        this.component = component;
    }

    public String execute() {
        String result = component.operation();
        return result;
    }
}
