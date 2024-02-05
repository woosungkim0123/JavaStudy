package abstract_factory.sub;

public class GoogleOS implements OS {
    @Override
    public void install() {
        System.out.println("Install GoogleOS");
    }

    @Override
    public void setting() {
        System.out.println("Setting GoogleOS");
    }
}
