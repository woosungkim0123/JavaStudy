package abstract_factory.sub;

public class IOS implements OS {
    @Override
    public void install() {
        System.out.println("Install iOS");
    }

    @Override
    public void setting() {
        System.out.println("Setting iOS");
    }
}
